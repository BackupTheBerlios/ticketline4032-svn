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
                    <webuijsf:form binding="#{Top10.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:table augmentTitle="false" binding="#{Top10.table1}" id="table1"
                                style="border-color: rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0) rgb(0, 0, 0); color: rgb(0, 0, 0); height: 220px; left: 0px; top: 72px; position: absolute; text-decoration: none; width: 743px" width="743">
                                <webuijsf:tableRowGroup binding="#{Top10.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{Top10.defaultTableDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{Top10.tableColumn1}" headerText="Platz" id="tableColumn1" sort="column1" style="null" width="101">
                                        <webuijsf:staticText binding="#{Top10.staticText1}" id="staticText1" text="#{currentRow.value['column1']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Top10.tableColumn2}" headerText="Name der Veranstaltung / Kategorie" id="tableColumn2"
                                        sort="column2" width="515">
                                        <webuijsf:staticText binding="#{Top10.staticText2}" id="staticText2" text="#{currentRow.value['column2']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Top10.tableColumn3}" headerText="Tickets" id="tableColumn3" sort="column3" width="92">
                                        <webuijsf:staticText binding="#{Top10.staticText3}" id="staticText3" text="#{currentRow.value['column3']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:staticText binding="#{Top10.staticText5}" id="staticText5"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 30px; height: 45px; left: 312px; top: 24px; position: absolute; width: 93px" text="Top10"/>
                            <webuijsf:button actionExpression="#{Top10.button1_action}" binding="#{Top10.button1}" id="button1"
                                style="height: 19px; left: 9px; top: 300px; position: absolute; width: 129px" text="Auswählen"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
