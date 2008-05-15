<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PlatzAuswahl
    Created on : 23.04.2008, 19:23:34
    Author     : Christoph Auernig
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{PlatzAuswahl.page1}" id="page1">
            <webuijsf:html binding="#{PlatzAuswahl.html1}" id="html1">
                <webuijsf:head binding="#{PlatzAuswahl.head1}" id="head1">
                    <webuijsf:link binding="#{PlatzAuswahl.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{PlatzAuswahl.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{PlatzAuswahl.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 694px; left: 192px; top: 144px; position: absolute; width: 742px">
                            <webuijsf:staticText binding="#{PlatzAuswahl.staticTextTitle}" id="staticTextTitle"
                                style="font-size: 30px; left: 240px; top: 0px; position: absolute" text="verfügbare Plätze"/>
                            <webuijsf:button actionExpression="#{PlatzAuswahl.button1_action}" binding="#{PlatzAuswahl.button1}" id="button1"
                                style="height: 23px; left: -1px; top: 144px; position: absolute; width: 168px" text="Ausgewählte Plätze reservieren"/>
                            <webuijsf:button actionExpression="#{PlatzAuswahl.button2_action}" binding="#{PlatzAuswahl.button2}" id="button2"
                                style="height: 23px; left: -1px; top: 192px; position: absolute; width: 168px" text="ausgewählte Plätze kaufen"/>
                            <jsp:useBean class="ticketline.PlatzAuswahl" id="PlatzAuswahl" scope="session"/>
                            <jsp:getProperty name="PlatzAuswahl" property="platzformat"/>
                            <webuijsf:dropDown binding="#{PlatzAuswahl.anzahl}" id="anzahl" items="#{PlatzAuswahl.anzahlDefaultOptions.options}" style="height: 23px; left: -1px; top: 110px; position: absolute; width: 168px"/>
                            <webuijsf:hiddenField binding="#{PlatzAuswahl.startplatz}" id="startplatz"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
