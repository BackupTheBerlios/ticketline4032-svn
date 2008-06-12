<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Top10.page1}" id="page1">
            <webuijsf:html binding="#{Top10.html1}" id="html1">
                <webuijsf:head binding="#{Top10.head1}" id="head1">
                    <webuijsf:link binding="#{Top10.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Top10.body1}" id="body1" style="-rave-layout: grid">
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{Top10.form1}" id="form1">
                        <div style="height: 478px; left: 192px; top: 144px; position: absolute; width: 750px">
                            <webuijsf:table augmentTitle="false" binding="#{Top10.table1}" id="table1"
                                title="Top 10 Veranstaltungen" width="743">
                                <webuijsf:tableRowGroup binding="#{Top10.tableRowGroup1}" emptyDataMsg="Keine Einträge gefunden." id="tableRowGroup1" rows="10"
                                    selected="#{Top10.selectedState}" sourceData="#{Top10.top10}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{Top10.tableColumn1}" id="tableColumn1"
                                        onClick="setTimeout(function(){document.getElementById('form1:table1').initAllRows()}, 0);" selectId="radioButton1" width="10">
                                        <webuijsf:radioButton binding="#{Top10.radioButton1}" id="radioButton1" label="" name="radioButton1"
                                            selected="#{Top10.selected}" selectedValue="#{Top10.selectedValue}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Top10.tableColumn4}" headerText="Veranstaltung" id="tableColumn4">
                                        <webuijsf:staticText binding="#{Top10.staticText5}" id="staticText5" text="#{currentRow.value.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Top10.tableColumn2}" headerText="Kategorie" id="tableColumn2">
                                        <webuijsf:staticText binding="#{Top10.staticText1}" id="staticText1" text="#{currentRow.value.comp_id.kategorie}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <br/>
                            <webuijsf:button actionExpression="#{Top10.button1_action}" binding="#{Top10.button1}" id="button1"
                                style="height: 19px; width: 129px" text="Auswählen"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
