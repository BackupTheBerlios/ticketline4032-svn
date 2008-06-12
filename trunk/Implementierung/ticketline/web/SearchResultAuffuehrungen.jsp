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
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{SearchResultAuffuehrungen.form1}" id="form1">
                        <div style="height: 694px; left: 192px; top: 144px; position: absolute; width: 742px">
                            <webuijsf:table augmentTitle="false" binding="#{SearchResultAuffuehrungen.table1}" id="table1" title="Aufführungen" width="739">
                                <webuijsf:tableRowGroup binding="#{SearchResultAuffuehrungen.tableRowGroup1}" emptyDataMsg="Keine Aufführungen."
                                    id="tableRowGroup1" rows="10" selected="#{SearchResultAuffuehrungen.selectedState}"
                                    sourceData="#{SearchResultAuffuehrungen.auffuehrung}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn2}" id="tableColumn2"
                                        onClick="setTimeout(function(){document.getElementById('form1:table1').initAllRows()}, 0);" selectId="radioButton1" width="10">
                                        <webuijsf:radioButton binding="#{SearchResultAuffuehrungen.radioButton1}" id="radioButton1" label="" name="radioButton1"
                                            selected="#{SearchResultAuffuehrungen.selected}" selectedValue="#{SearchResultAuffuehrungen.selectedValue}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn1}" headerText="Zeitpunkt" id="tableColumn1" width="150">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText1}" id="staticText1" text="#{currentRow.value.comp_id.datumuhrzeit}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn4}" headerText="Veranstaltung" id="tableColumn4">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText4}" id="staticText4" text="#{currentRow.value.veranstaltung.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{SearchResultAuffuehrungen.tableColumn5}" headerText="Saal" id="tableColumn5" width="100">
                                        <webuijsf:staticText binding="#{SearchResultAuffuehrungen.staticText5}" id="staticText5" text="#{currentRow.value.saal.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <br/>
                            <webuijsf:button actionExpression="#{SearchResultAuffuehrungen.buttonSelect_action}"
                                binding="#{SearchResultAuffuehrungen.buttonSelect}" id="buttonSelect" style="height: 19px; width: 129px" text="Auswählen"/>
                            <webuijsf:hiddenField binding="#{SearchResultAuffuehrungen.hiddenField1}" id="hiddenField1"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
