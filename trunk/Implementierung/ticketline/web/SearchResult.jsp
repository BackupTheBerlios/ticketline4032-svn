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
                                style="font-size: 30px; left: 0px; top: 0px; position: absolute" text="Suchergebnisse"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table1}" id="table1"
                                style="left: 0px; top: 48px; position: absolute; width: 741px" title="Orte" width="741">
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
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn6}" headerText="Straße" id="tableColumn6" sort="Straße">
                                        <webuijsf:staticText binding="#{SearchResult.staticText6}" id="staticText6" text="Straße"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table2}" id="table2"
                                style="left: 0px; top: 216px; position: absolute; width: 696px" title="Künstler" width="741">
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
                            <div style="left: 0px; top: 384px; position: absolute">
                                <jsp:directive.include file="VeranstaltungsFragment.jspf" />
                            </div>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
