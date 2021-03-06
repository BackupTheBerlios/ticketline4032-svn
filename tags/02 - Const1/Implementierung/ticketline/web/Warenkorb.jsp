<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Warenkorb.page1}" id="page1">
            <webuijsf:html binding="#{Warenkorb.html1}" id="html1">
                <webuijsf:head binding="#{Warenkorb.head1}" id="head1">
                    <webuijsf:link binding="#{Warenkorb.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Warenkorb.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Warenkorb.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:staticText binding="#{Warenkorb.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 30px; height: 45px; left: 312px; top: 24px; position: absolute; width: 93px" text="Warenkorb"/>
                            <div style="height: 141px; left: 24px; top: 72px; position: absolute; width: 717px">
                                <webuijsf:table augmentTitle="false" binding="#{Warenkorb.table1}" id="table1" width="450">
                                    <webuijsf:tableRowGroup binding="#{Warenkorb.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{Warenkorb.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{Warenkorb.tableColumn1}" headerText="Artikelnummer" id="tableColumn1" sort="column1">
                                            <webuijsf:staticText binding="#{Warenkorb.staticText2}" id="staticText2" text="#{currentRow.value['column1']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Warenkorb.tableColumn2}" headerText="Titel" id="tableColumn2" sort="column2">
                                            <webuijsf:staticText binding="#{Warenkorb.staticText3}" id="staticText3" text="#{currentRow.value['column2']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Warenkorb.tableColumn3}" headerText="Preis" id="tableColumn3" sort="column3">
                                            <webuijsf:staticText binding="#{Warenkorb.staticText4}" id="staticText4" text="#{currentRow.value['column3']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <webuijsf:button actionExpression="#{Warenkorb.button2_action}" binding="#{Warenkorb.button2}" id="button2"
                                    style="height: 23px; left: 503px; top: 72px; position: absolute; width: 119px" text="Zur Kassa"/>
                            </div>
                            <webuijsf:staticText binding="#{Warenkorb.staticText5}" id="staticText5"
                                style="height: 100px; left: 24px; top: 264px; position: absolute; width: 453px" text="Hier könnte die Beschreibung ihre Ware stehen ..."/>
                            <webuijsf:button binding="#{Warenkorb.button1}" id="button1"
                                style="height: 23px; left: 527px; top: 96px; position: absolute; width: 119px" text="löschen"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
