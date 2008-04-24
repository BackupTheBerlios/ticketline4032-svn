<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchResult
    Created on : 23.04.2008, 10:58:52
    Author     : Christoph Auernig
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{SearchResult.page1}" id="page1">
            <webuijsf:html binding="#{SearchResult.html1}" id="html1">
                <webuijsf:head binding="#{SearchResult.head1}" id="head1">
                    <webuijsf:link binding="#{SearchResult.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{SearchResult.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{SearchResult.form1}" id="form1" virtualFormsConfig="">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 694px; left: 192px; top: 144px; position: absolute; width: 742px">
                            <webuijsf:staticText binding="#{SearchResult.staticTextTitle}" id="staticTextTitle"
                                style="font-size: 30px; left: 264px; top: 0px; position: absolute" text="Suchergebnisse"/>
                            <webuijsf:staticText binding="#{SearchResult.staticTextOrte}" id="staticTextOrte"
                                style="font-size: 20px; left: 312px; top: 72px; position: absolute" text="gefundene Orte"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table1}" id="table1"
                                style="left: 24px; top: 120px; position: absolute; width: 696px" width="696">
                                <webuijsf:tableRowGroup binding="#{SearchResult.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                    sourceData="#{SearchResult.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn1}" headerText="Bezeichnung" id="tableColumn1" sort="Bezeichnung">
                                        <webuijsf:staticText binding="#{SearchResult.staticText1}" id="staticText1" text="Bezeichnung"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn2}" headerText="Ort" id="tableColumn2" sort="Ort">
                                        <webuijsf:staticText binding="#{SearchResult.staticText2}" id="staticText2" text="Ort"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn3}" headerText="PLZ" id="tableColumn3" sort="PLZ">
                                        <webuijsf:staticText binding="#{SearchResult.staticText3}" id="staticText3" text="PLZ"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn4}" headerText="Straße" id="tableColumn4" sort="Straße">
                                        <webuijsf:staticText binding="#{SearchResult.staticText4}" id="staticText4" text="Straße"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn5}" headerText="Bundesland" id="tableColumn5" sort="Bundesland">
                                        <webuijsf:staticText binding="#{SearchResult.staticText5}" id="staticText5" text="Bundesland"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn4}" headerText="Straße" id="tableColumn4" sort="Straße">
                                        <webuijsf:staticText binding="#{SearchResult.staticText4}" id="staticText4" text="Straße"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:staticText binding="#{SearchResult.staticTextKuenstler}" id="staticTextKuenstler"
                                style="font-size: 20px; left: 312px; top: 288px; position: absolute" text="gefundene Künstler"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table2}" id="table2"
                                style="left: 24px; top: 336px; position: absolute; width: 696px" width="696">
                                <webuijsf:tableRowGroup binding="#{SearchResult.tableRowGroup2}" id="tableRowGroup2" rows="5"
                                    sourceData="#{SearchResult.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn9}" headerText="Nachname" id="tableColumn9" sort="Nachname">
                                        <webuijsf:staticText binding="#{SearchResult.staticText9}" id="staticText9" text="Nachname"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn10}" headerText="Vorname" id="tableColumn10" sort="Vorname">
                                        <webuijsf:staticText binding="#{SearchResult.staticText10}" id="staticText10" text="Vorname"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn11}" headerText="Geschlecht" id="tableColumn11" sort="Geschlecht">
                                        <webuijsf:staticText binding="#{SearchResult.staticText11}" id="staticText11" text="Geschlecht"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:staticText binding="#{SearchResult.staticTextVeranstaltungen}" id="staticTextVeranstaltungen"
                                style="font-size: 20px; left: 264px; top: 504px; position: absolute" text="gefundene Veranstaltungen"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table3}" id="table3"
                                style="left: 24px; top: 552px; position: absolute; width: 696px" width="696">
                                <webuijsf:tableRowGroup binding="#{SearchResult.tableRowGroup3}" id="tableRowGroup3" rows="5"
                                    sourceData="#{SearchResult.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn15}" headerText="Bezeichnung" id="tableColumn15" sort="Bezeichnung">
                                        <webuijsf:staticText binding="#{SearchResult.staticText15}" id="staticText15" text="Bezeichnung"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn16}" headerText="Kategorie" id="tableColumn16" sort="Kategorie">
                                        <webuijsf:staticText binding="#{SearchResult.staticText16}" id="staticText16" text="Kategorie"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn17}" headerText="Dauer" id="tableColumn17" sort="Dauer">
                                        <webuijsf:staticText binding="#{SearchResult.staticText17}" id="staticText17" text="Dauer"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn18}" headerText="Inhalt" id="tableColumn18" sort="Inhalt">
                                        <webuijsf:staticText binding="#{SearchResult.staticText18}" id="staticText18" text="Inhalt"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
