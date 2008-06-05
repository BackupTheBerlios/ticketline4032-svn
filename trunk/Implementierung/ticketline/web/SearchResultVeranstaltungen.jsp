<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchResultVeranstaltungen
    Created on : 23.04.2008, 17:12:14
    Author     : Christoph Auernig
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{SearchResultVeranstaltungen.page1}" id="page1">
            <webuijsf:html binding="#{SearchResultVeranstaltungen.html1}" id="html1">
                <webuijsf:head binding="#{SearchResultVeranstaltungen.head1}" id="head1">
                    <webuijsf:link binding="#{SearchResultVeranstaltungen.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{SearchResultVeranstaltungen.body1}" id="body1" style="-rave-layout: grid">
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{SearchResultVeranstaltungen.form1}" id="form1">
                        <webuijsf:hiddenField binding="#{SearchResultVeranstaltungen.hiddenFieldKuenstlerNr}" id="hiddenFieldKuenstlerNr"/>
                        <webuijsf:hiddenField binding="#{SearchResultVeranstaltungen.hiddenFieldOrt}" id="hiddenFieldOrt"/>
                        <webuijsf:hiddenField binding="#{SearchResultVeranstaltungen.hiddenFieldBez}" id="hiddenFieldBez"/>
                    </webuijsf:form>
                    <div style="left: 190px; top: 150px; position: absolute">
                        <jsp:directive.include file="VeranstaltungsFragment.jspf"/>
                    </div>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
