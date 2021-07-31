//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("SysMenuPageController")
@RequestMapping({"business/oauth/menu"})
public class MenuPageController {
    public static final String prefix = "business/oauth/menu";

    public MenuPageController() {
    }

    @RequestMapping({"/menu_list.html"})
    public String list(Model model) {
        return "business/oauth/menu/menu_list";
    }

    @RequestMapping({"/menu_dialog.html"})
    public String dialog(Model model) {
        return "business/oauth/menu/menu_dialog";
    }

    @RequestMapping({"/menu_form.html"})
    public String form(Model model, String id) {
        return "business/oauth/menu/menu_form";
    }
}
