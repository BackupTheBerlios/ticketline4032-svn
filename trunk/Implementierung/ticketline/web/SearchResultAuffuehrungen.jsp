<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchResultAufführungen
    Created on : 23.04.2008, 17:53:25
    Author     : Christoph Auernig
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{SearchResultAuffuehrungen.page1}" id="page1">
            <webuijsf:html binding="#{SearchResultAuffuehrungen.html1}" id="html1">
                <webuijsf:head binding="#{SearchResultAuffuehrungen.head1}" id="head1">
                    <webuijsf:link binding="#{SearchResultAuffuehrungen.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{SearchResultAuffuehrungen.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{SearchResultAuffuehrungen.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 694px; left: 192px; top: 144px; position: absolute; width: 742px">
                            <webuijsf:staticText binding="#{SearchResultAuffuehrungen.auffuehrung}" id="staticTextTitle"
                                style="font-size: 30px; left: 192px; top: 0px; position: absolute" text="gefundene Aufführungen"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResultAuffuehrungen.table1}" id="table1"
                                style="left: 24px; top: 72px; position: absolute" width="695">
                                <webuijsf:tableRowGroup binding="#{SearchResultAuffuehrungen.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                    sourceData="#{SearchResultAuffuehrungen.auffuehrung}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn1}" headerText="DatumUhrzeit" id="tableColumn1"
                                        sort="DatumUhrzeit" width="100">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText1}" id="staticText1" text="#{currentRow.value.comp_id.datumuhrzeit}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn2}" headerText="Storniert" id="tableColumn2"
                                        sort="Storniert" width="30">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText2}" id="staticText2" text="#{currentRow.value.storniert}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn3}" headerText="Preis" id="tableColumn3" sort="Preis" width="30">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText3}" id="staticText3" text="#{currentRow.value.preis}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn4}" headerText="Veranstaltung" id="tableColumn4"
                                        sort="Veranstaltung" width="130">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText4}" id="staticText4" text="#{currentRow.value.veranstaltung.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn5}" headerText="Saal" id="tableColumn5" sort="Saal" width="46">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText5}" id="staticText5" text="#{currentRow.value.saal.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn6}" headerText="freie Plätze" id="tableColumn6"
                                        sort="freie Plätze" width="70">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText6}" id="staticText6" text="anz frei"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{SearchResultAuffuehrungen.button1_action}" binding="#{SearchResultAuffuehrungen.button1}"
                                id="button1" style="height: 19px; left: 29px; top: 210px; position: absolute; width: 129px" text="Auswählen"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
