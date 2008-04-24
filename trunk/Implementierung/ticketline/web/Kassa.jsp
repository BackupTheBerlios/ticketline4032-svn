<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Kassa.page1}" id="page1">
            <webuijsf:html binding="#{Kassa.html1}" id="html1">
                <webuijsf:head binding="#{Kassa.head1}" id="head1">
                    <webuijsf:link binding="#{Kassa.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Kassa.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Kassa.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:staticText binding="#{Kassa.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; height: 100px; left: 24px; top: 96px; position: absolute; width: 453px" text="Hier wird ihre Rechnung stehen, die wo Sie sich dann natürlich auch ausdrucken können, muss mir aber erst anschauen wie man richtig rechnungen schreibt, wird aber so ca im amazon stil sein ..."/>
                            <webuijsf:button actionExpression="#{Kassa.button1_action}" binding="#{Kassa.button1}" id="button1"
                                style="height: 23px; left: 527px; top: 432px; position: absolute; width: 95px" text="Kaufen"/>
                            <webuijsf:staticText binding="#{Kassa.staticText2}" id="staticText2"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 30px; height: 45px; left: 312px; top: 24px; position: absolute; width: 93px" text="Kassa"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
