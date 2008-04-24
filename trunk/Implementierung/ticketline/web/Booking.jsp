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
                    <webuijsf:form binding="#{Booking.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:staticText binding="#{Booking.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 30px; height: 45px; left: 264px; top: 24px; position: absolute; width: 213px" text="Reservierungen"/>
                            <div style="height: 141px; left: 24px; top: 72px; position: absolute; width: 717px">
                                <webuijsf:table augmentTitle="false" binding="#{Booking.table1}" id="table1" width="572">
                                    <webuijsf:tableRowGroup binding="#{Booking.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{Booking.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{Booking.tableColumn1}" headerText="Datum" id="tableColumn1" sort="column1" width="90">
                                            <webuijsf:staticText binding="#{Booking.staticText2}" id="staticText2" text="#{currentRow.value['column1']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Booking.tableColumn2}" headerText="Zeit" id="tableColumn2" sort="column2"
                                                width="82">Zeit
                                            <webuijsf:staticText
                                                binding="#{Booking.staticText3}" id="staticText3" text="#{currentRow.value['column2']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Booking.tableColumn3}" headerText="Aufführung" id="tableColumn3" sort="column3">
                                            <webuijsf:staticText binding="#{Booking.staticText4}" id="staticText4" text="#{currentRow.value['column3']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Booking.tableColumn4}" headerText="Reservierungsnummer" id="tableColumn4" width="200">
                                            <webuijsf:staticText binding="#{Booking.staticText6}" id="staticText6" text="Static Text"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Booking.tableColumn5}" headerText="Preis" id="tableColumn5" width="200">
                                            <webuijsf:staticText binding="#{Booking.staticText7}" id="staticText7" text="Static Text"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <webuijsf:button binding="#{Booking.button3}" id="button3"
                                    style="height: 23px; left: 589px; top: 80px; position: absolute; width: 110px" text="Stornieren"/>
                                <webuijsf:button binding="#{Booking.button1}" id="button1"
                                    style="height: 23px; left: 589px; top: 110px; position: absolute; width: 110px" text="Kaufen"/>
                            </div>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
