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
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table1}" id="table1" paginateButton="true" paginationControls="true"
                                style="left: 0px; top: 72px; position: absolute; width: 741px" title="Orte" width="741">
                                <webuijsf:tableRowGroup binding="#{SearchResult.tableRowGroup1}"
                                    emptyDataMsg="Es wurden keine Orte gefunden die Ihrer Suchanfrage entsprechen." id="tableRowGroup1" rows="5"
                                    sourceData="#{SearchResult.orte}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn1}" headerText="Bezeichnung" id="tableColumn1" sort="comp_id.bezeichnung">
                                        <webuijsf:staticText binding="#{SearchResult.staticText1}" id="staticText1" text="#{currentRow.value.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn2}" headerText="Ort" id="tableColumn2" sort="comp_id.ort">
                                        <webuijsf:staticText binding="#{SearchResult.staticText2}" id="staticText2" text="#{currentRow.value.comp_id.ort}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn3}" headerText="PLZ" id="tableColumn3" sort="plz">
                                        <webuijsf:staticText binding="#{SearchResult.staticText3}" id="staticText3" text="#{currentRow.value.plz}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn4}" headerText="Straße" id="tableColumn4" sort="strasse">
                                        <webuijsf:staticText binding="#{SearchResult.staticText4}" id="staticText4" text="#{currentRow.value.strasse}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn5}" headerText="Bundesland" id="tableColumn5" sort="bundesland">
                                        <webuijsf:staticText binding="#{SearchResult.staticText5}" id="staticText5" text="#{currentRow.value.bundesland}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResult.table2}" id="table2" paginateButton="true" paginationControls="true"
                                style="left: 0px; top: 312px; position: absolute; width: 741px" title="Künstler" width="741">
                                <webuijsf:tableRowGroup binding="#{SearchResult.tableRowGroup2}"
                                    emptyDataMsg="Es wurden keine Künstler gefunden die Ihrer Suchanfrage entsprechen." id="tableRowGroup2" rows="5"
                                    sourceData="#{SearchResult.kuenstler}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn9}" headerText="Nachname" id="tableColumn9" sort="nname">
                                        <webuijsf:staticText binding="#{SearchResult.staticText9}" id="staticText9" text="#{currentRow.value.nname}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn10}" headerText="Vorname" id="tableColumn10" sort="vname">
                                        <webuijsf:staticText binding="#{SearchResult.staticText10}" id="staticText10" text="#{currentRow.value.vname}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResult.tableColumn11}" headerText="Geschlecht" id="tableColumn11" sort="geschlecht">
                                        <webuijsf:staticText binding="#{SearchResult.staticText11}" id="staticText11" text="#{currentRow.value.geschlecht}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <div style="left: 0px; top: 552px; position: absolute">
                                <jsp:directive.include file="VeranstaltungsFragment.jspf" />
                            </div>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
