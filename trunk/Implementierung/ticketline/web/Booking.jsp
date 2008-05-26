<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Booking.page1}" id="page1">
            <webuijsf:html binding="#{Booking.html1}" id="html1">
                <webuijsf:head binding="#{Booking.head1}" id="head1">
                    <webuijsf:link binding="#{Booking.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Booking.body1}" id="body1" style="-rave-layout: grid">
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{Booking.form1}" id="form1">
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:table augmentTitle="false" binding="#{Booking.table1}" id="table1" style="left: 0px; top: 48px; position: absolute"
                                title="Reservierungen" width="743">
                                <webuijsf:tableRowGroup binding="#{Booking.tableRowGroup1}" id="tableRowGroup1" rows="10" selected="#{Booking.selectedState}"
                                    sourceData="#{Booking.reservierungen}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{Booking.tableColumn1}" id="tableColumn1"
                                        onClick="setTimeout(function(){document.getElementById('form1:table1').initAllRows()}, 0);" selectId="radioButton1" width="10">
                                        <webuijsf:radioButton binding="#{Booking.radioButton1}" id="radioButton1" name="radioButton1"
                                            selected="#{Booking.selected}" selectedValue="#{Booking.selectedValue}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Booking.tableColumn6}" headerText="Zeit" id="tableColumn6">
                                        <webuijsf:staticText binding="#{Booking.staticText1}" id="staticText1" text="#{currentRow.value.comp_id.datumuhrzeit}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Booking.tableColumn7}" headerText="Reservierung" id="tableColumn7" sort="resnr">
                                        <webuijsf:staticText binding="#{Booking.staticText5}" id="staticText5" text="#{currentRow.value['resnr']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Booking.tableColumn8}" headerText="Veranstaltung" id="tableColumn8">
                                        <webuijsf:staticText binding="#{Booking.staticText8}" id="staticText8" text="#{currentRow.value.belegung.auffuehrung.veranstaltung.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Booking.tableColumn9}" headerText="Preis" id="tableColumn9" sort="preis">
                                        <webuijsf:staticText binding="#{Booking.staticText9}" id="staticText9" text="#{currentRow.value['preis']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Booking.buttonBuy_action}" binding="#{Booking.button1}" id="button1"
                                style="height: 20px; left: -1px; top: 24px; position: absolute; width: 110px" text="Kaufen"/>
                            <webuijsf:button actionExpression="#{Booking.buttonRevoke_action}" binding="#{Booking.button3}" id="button3"
                                style="height: 20px; left: 119px; top: 24px; position: absolute; width: 110px" text="Stornieren"/>
                            <webuijsf:label binding="#{Booking.labelStatus}" id="labelStatus" style="left: 240px; top: 24px; position: absolute"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
