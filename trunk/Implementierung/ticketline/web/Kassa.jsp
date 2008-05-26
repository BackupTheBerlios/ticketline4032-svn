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
                        <webuijsf:label binding="#{Kassa.label1}" id="label1" style="left: 192px; top: 125px; position: absolute" text="Rechnung"/>
                        <div style="height: 478px; left: 192px; top: 150px; position: absolute; width: 750px">
                            <jsp:useBean class="ticketline.Kassa" id="Kassa" scope="session"/>
                            <jsp:getProperty name="Kassa" property="rechnung"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
