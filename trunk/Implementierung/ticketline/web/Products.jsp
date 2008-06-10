<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Products.page1}" id="page1">
            <webuijsf:html binding="#{Products.html1}" id="html1">
                <webuijsf:head binding="#{Products.head1}" id="head1">
                    <webuijsf:link binding="#{Products.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Products.body1}" id="body1" style="-rave-layout: grid">
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{Products.form1}" id="form1">
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:table augmentTitle="false" binding="#{Products.table1}" id="table1" style="top: 24px; position: relative;"
                                title="Artikel" width="740">
                                <webuijsf:tableRowGroup binding="#{Products.tableRowGroup1}" emptyDataMsg="Keine Produkte." id="tableRowGroup1" rows="10"
                                    selected="#{Products.selectedState}" sourceData="#{Products.artikel}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{Products.tableColumn2}" id="tableColumn2" 
                                        onClick="setTimeout(function(){document.getElementById('form1:table1').initAllRows()}, 0);" selectId="radioButton1" width="10">
                                        <webuijsf:radioButton binding="#{Products.radioButton1}" id="radioButton1" name="radioButton1" 
                                            selected="#{Products.selected}" selectedValue="#{Products.selectedValue}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Products.tableColumn4}" headerText="Typ" id="tableColumn4" sort="kurzbezeichnung" width="50">
                                        <webuijsf:staticText binding="#{Products.staticText1}" id="staticText1" text="#{currentRow.value['kurzbezeichnung']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Products.tableColumn5}" headerText="Veranstaltung" id="tableColumn5" width="150">
                                        <webuijsf:staticText binding="#{Products.staticText5}" id="staticText5" text="#{currentRow.value.veranstaltung.comp_id.bezeichnung}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{Products.tableColumn1}" headerText="Beschreibung" id="tableColumn1" sort="beschreibung">
                                        <webuijsf:staticText binding="#{Products.staticText2}" id="staticText2" text="#{currentRow.value['beschreibung']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn align="right" binding="#{Products.tableColumn6}" headerText="Preis €" id="tableColumn6" sort="preis" width="50">
                                        <webuijsf:staticText binding="#{Products.staticText6}" id="staticText6" text="#{currentRow.value['preis']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <br />
                            <webuijsf:button actionExpression="#{Products.button1_action}" binding="#{Products.button1}" id="button1"
                                style="height: 23px; position: relative; width: 119px" text="in den Warenkorb"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
