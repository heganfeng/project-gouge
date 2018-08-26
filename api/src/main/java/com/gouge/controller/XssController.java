package com.gouge.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.util.HtmlUtils;

/**
 * 处理xss攻击
 *
 * @author xianyongjie
 */
public class XssController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new XssPropertyEditor());
    }

    class XssPropertyEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (!StringUtils.isBlank(text)) {
                text = HtmlUtils.htmlEscape(text).replace("&quot;", "\"");
            }
            super.setValue(text);
        }
    }
}
