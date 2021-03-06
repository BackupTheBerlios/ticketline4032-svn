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
                    <webuijsf:form binding="#{SearchResultVeranstaltungen.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 454px; left: 190px; top: 140px; position: absolute; width: 742px">
                            <webuijsf:staticText binding="#{SearchResultVeranstaltungen.staticTextTitle}" id="staticTextTitle"
                                style="font-size: 30px; left: 192px; top: 0px; position: absolute" text="gefundene Veranstaltungen"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResultVeranstaltungen.table1}" id="table1"
                                style="left: 24px; top: 72px; position: absolute" width="695">
                                <webuijsf:tableRowGroup binding="#{SearchResultVeranstaltungen.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                    sourceData="#{SearchResultVeranstaltungen.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResultVeranstaltungen.tableColumn1}" headerText="Bezeichnung" id="tableColumn1"
                                        sort="Bezeichnung" width="221">
                                        <webuijsf:staticText binding="#{SearchResultVeranstaltungen.staticText1}" id="staticText1" text="Bezeichnung"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultVeranstaltungen.tableColumn2}" headerText="Kategorie" id="tableColumn2"
                                        sort="Kategorie" width="154">
                                        <webuijsf:staticText binding="#{SearchResultVeranstaltungen.staticText2}" id="staticText2" text="Kategorie"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultVeranstaltungen.tableColumn3}" headerText="Dauer" id="tableColumn3"
                                        sort="Dauer" width="132">
                                        <webuijsf:staticText binding="#{SearchResultVeranstaltungen.staticText3}" id="staticText3" text="Dauer"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultVeranstaltungen.tableColumn4}" headerText="Inhalt" id="tableColumn4"
                                        sort="Inhalt" width="544">
                                        <webuijsf:staticText binding="#{SearchResultVeranstaltungen.staticText4}" id="staticText4" text="Inhalt"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{SearchResultVeranstaltungen.button1_action}" binding="#{SearchResultVeranstaltungen.button1}"
                                id="button1" style="height: 19px; left: 29px; top: 210px; position: absolute; width: 129px" text="Auswählen"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
