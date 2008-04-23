<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchResultAufführungen
    Created on : 23.04.2008, 17:12:14
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
                            <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticTextVeranstaltungen1}" id="staticTextVeranstaltungen1"
                                style="font-size: 30px; left: 192px; top: 0px; position: absolute" text="gefundene Aufführungen"/>
                            <webuijsf:table augmentTitle="false" binding="#{SearchResultAuffuehrungen.table1}" id="table1"
                                style="left: 24px; top: 72px; position: absolute" width="695">
                                <webuijsf:tableRowGroup binding="#{SearchResultAuffuehrungen.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                    sourceData="#{SearchResultAuffuehrungen.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn1}" headerText="DatumUhrzeit" id="tableColumn1"
                                        sort="DatumUhrzeit" width="210">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText1}" id="staticText1" text="DatumUhrzeit"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn2}" headerText="Storniert" id="tableColumn2"
                                        sort="Storniert" width="154">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText2}" id="staticText2" text="Storniert"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn3}" headerText="Preis" id="tableColumn3" sort="Preis" width="115">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText3}" id="staticText3" text="Preis"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn4}" headerText="Veranstaltung" id="tableColumn4"
                                        sort="Veranstaltung" width="116">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText4}" id="staticText4" text="Veranstaltung"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn5}" headerText="Saal" id="tableColumn5" sort="Saal" width="46">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText5}" id="staticText5" text="Saal"/>
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
