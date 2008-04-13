<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LoginPage
    Created on : Apr 14, 2008, 11:23:51 PM
    Author     : RedFalcon
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{LoginPage.page1}" id="page1">
            <webuijsf:html binding="#{LoginPage.html1}" id="html1">
                <webuijsf:head binding="#{LoginPage.head1}" id="head1">
                    <webuijsf:link binding="#{LoginPage.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{LoginPage.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{LoginPage.form1}" id="form1">
                        <webuijsf:button actionExpression="#{LoginPage.button1_action}" binding="#{LoginPage.button1}" id="button1"
                            style="left: 143px; top: 168px; position: absolute; width: 120px" text="Button"/>
                        <webuijsf:textField binding="#{LoginPage.textField1}" id="textField1" style="left: 144px; top: 120px; position: absolute"/>
                        <webuijsf:staticText binding="#{LoginPage.staticText1}" id="staticText1" style="position: absolute; left: 144px; top: 96px" text="Some Text"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
