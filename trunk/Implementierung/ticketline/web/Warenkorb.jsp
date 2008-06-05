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
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{Warenkorb.form1}" id="form1">
                        <webuijsf:button actionExpression="#{Warenkorb.button2_action}" binding="#{Warenkorb.button2}" id="button2" onClick="javascript:confirm('Wollen sie die Artikel kaufen?');"
                            style="height: 20px; left: 311px; top: 144px; position: absolute; width: 119px" text="Kaufen"/>
                        <webuijsf:table augmentTitle="false" binding="#{Warenkorb.table1}" id="table1" style="left: 192px; top: 168px; position: absolute"
                            title="Table" width="744">
                            <webuijsf:tableRowGroup binding="#{Warenkorb.tableRowGroup1}" emptyDataMsg="Keine Produkte." id="tableRowGroup1" rows="10"
                                selected="#{Warenkorb.selectedState}" sourceData="#{SessionBean1.warenkorb}" sourceVar="currentRow">
                                <webuijsf:tableColumn binding="#{Warenkorb.tableColumn2}" id="tableColumn2"
                                    onClick="setTimeout(function(){document.getElementById('form1:table1').initAllRows()}, 0);" selectId="radioButton1" width="10">
                                    <webuijsf:radioButton binding="#{Warenkorb.radioButton1}" id="radioButton1" name="radioButton1"
                                        selected="#{Warenkorb.selected}" selectedValue="#{Warenkorb.selectedValue}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{Warenkorb.tableColumn4}" headerText="Typ" id="tableColumn4" sort="kurzbezeichnung" width="50">
                                    <webuijsf:staticText binding="#{Warenkorb.staticText1}" id="staticText1" text="#{currentRow.value['kurzbezeichnung']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{Warenkorb.tableColumn5}" headerText="Veranstaltung" id="tableColumn5" width="150">
                                    <webuijsf:staticText binding="#{Warenkorb.staticText5}" id="staticText5" text="#{currentRow.value.veranstaltung.comp_id.bezeichnung}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{Warenkorb.tableColumn1}" headerText="Beschreibung" id="tableColumn1" sort="beschreibung">
                                    <webuijsf:staticText binding="#{Warenkorb.staticText2}" id="staticText2" text="#{currentRow.value['beschreibung']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="right" binding="#{Warenkorb.tableColumn6}" headerText="Preis €" id="tableColumn6" sort="preis" width="50">
                                    <webuijsf:staticText binding="#{Warenkorb.staticText6}" id="staticText6" text="#{currentRow.value['preis']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:dropDown binding="#{Warenkorb.dropDown1}" id="dropDown1" items="#{Warenkorb.dropDown1DefaultOptions.options}"
                            label="Zahlungsart" style="left: 456px; top: 144px; position: absolute; width: 200px"/>
                        <webuijsf:button actionExpression="#{Warenkorb.button1_action}" binding="#{Warenkorb.button1}" id="button1" onClick="javascript:confirm('Wollen sie den gewählten Artikel entfernen?');"
                            style="height: 20px; left: 191px; top: 144px; position: absolute; width: 119px" text="Artikel löschen"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
