DELIMITER ;;
CREATE PROCEDURE `NEXT_VAL`(IN ID varchar(100),IN TID varchar(100),IN NUM int,OUT SVAL varchar(4000))
BEGIN

    DECLARE VAL bigint;
    DECLARE USQID varchar(32);
    DECLARE SQNUM varchar(32);
    DECLARE TP varchar(16);
    DECLARE CATA VARCHAR(16);
    DECLARE T_CATA VARCHAR(16);
    DECLARE LEN int;
    DECLARE LEN_X int;
    DECLARE i int;

	DECLARE MIN bigint;
    DECLARE MAX bigint;

    SET SQL_SAFE_UPDATES = 0;

    set USQID=lower(ID);
    set SVAL='';
    -- SELECT 'P1';
	-- SELECT USQID;
    start transaction;

    -- select  count(1)  KK  FROM SYS_SEQUENCE A where A.ID=USQID; -- 必须加别名

    select VALUE,TYPE,CATALOG,LENGTH into VAL,TP,CATA,LEN  FROM sys_sequence A where A.ID=USQID and A.TENANT_ID=TID  for update;
	SELECT VAL;
    if VAL is null then
		set VAL=0;
    end if;

    IF TP='AI' THEN
		set MIN=VAL+1;
        set VAL=VAL+NUM-1;
	ELSEIF TP='DAI' then
        set T_CATA=DATE_FORMAT(now(),'%Y%m%d');
        if T_CATA!=CATA or CATA is null then
            update sys_sequence A set A.CATALOG=T_CATA where  A.ID=USQID and A.TENANT_ID=TID;
            set CATA=T_CATA;
            set VAL=0;
        end if;
        set MIN=VAL+1;
        set VAL=VAL+NUM-1;
    ELSEIF TP='MAI' then
        set T_CATA=DATE_FORMAT(now(),'%Y%m');
        if T_CATA!=CATA or CATA is null then
            update sys_sequence A set A.CATALOG=T_CATA where  A.ID=USQID and A.TENANT_ID=TID;
            set CATA=T_CATA;
            set VAL=0;
        end if;
        set MIN=VAL+1;
        set VAL=VAL+NUM-1;
    ELSEIF TP='YAI' then
        set T_CATA=DATE_FORMAT(now(),'%Y');
        if T_CATA!=CATA or CATA is null then
            update sys_sequence A set A.CATALOG=T_CATA where  A.ID=USQID and A.TENANT_ID=TID;
            set CATA=T_CATA;
            set VAL=0;
        end if;
		set MIN=VAL+1;
        set VAL=VAL+NUM-1;
    ELSEIF TP='WAI_1' then
        set T_CATA=DATE_FORMAT(now(),'%X%V');
        -- select T_CATA;
		-- select CATA;
        if T_CATA!=CATA or CATA is null then
            update sys_sequence A set A.CATALOG=T_CATA where  A.ID=USQID and A.TENANT_ID=TID;
            set CATA=T_CATA;
            set VAL=0;
        end if;
        set MIN=VAL+1;
        set VAL=VAL+NUM-1;
    ELSEIF TP='WAI_2' then
        set T_CATA=DATE_FORMAT(now(),'%x%v');
        if T_CATA!=CATA or CATA is null then
            update sys_sequence A set A.CATALOG=T_CATA where  A.ID=USQID and A.TENANT_ID=TID;
            set CATA=T_CATA;
            set VAL=0;
        end if;
        set MIN=VAL+1;
        set VAL=VAL+NUM-1;
	ELSE
		 set CATA='ERROR';
         set VAL=8090;
	END IF;




    -- select USQID;
	UPDATE sys_sequence A set A.VALUE=VAL where  A.ID=USQID and A.TENANT_ID=TID;

    commit;


    set MAX=VAL;


    while MIN <= MAX DO

		set SQNUM=concat(MIN,'');

		set len_x=len-LENGTH(SQNUM)-1;

		-- select len,SQNUM;


		set i=0;
		WHILE i <= len_x DO
			set SQNUM = concat('0',SQNUM);
			set i=i+1;
		END WHILE;

		-- select SVAL;

		if TP!='AI' then
			set SQNUM=concat(CATA,SQNUM);
		 END IF;

         set SVAL=concat(SVAL,SQNUM,',');

         set MIN=MIN+1;
		 -- select CATA;
     END WHILE;

END;;
DELIMITER ;