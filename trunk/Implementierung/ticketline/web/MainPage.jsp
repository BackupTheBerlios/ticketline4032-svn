<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{MainPage.page1}" id="page1">
            <webuijsf:html binding="#{MainPage.html1}" id="html1">
                <webuijsf:head binding="#{MainPage.head1}" id="head1">
                    <webuijsf:link binding="#{MainPage.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{MainPage.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{MainPage.form1}" id="form1">
                        <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="MasterFragment.jspf"/>
                        </div>
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:staticText binding="#{MainPage.id_News}" id="id_News"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; height: 45px; left: 24px; top: 24px; position: absolute; width: 69px" text="News"/>
                            <div
                                    style="height: 400px; left: 24px; top: 72px; position: absolute; width: 600px">
                                <webuijsf:table
                                    augmentTitle="false" binding="#{MainPage.table1}" id="table1" width="599">
                                    <webuijsf:tableRowGroup binding="#{MainPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{MainPage.defaultTableDataProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{MainPage.tableColumn1}" headerText="Datum" id="tableColumn1" sort="column1">
                                            <webuijsf:staticText binding="#{MainPage.staticText1}" id="staticText1" text="#{currentRow.value['column1']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{MainPage.tableColumn2}" headerText="Schlagzeile" id="tableColumn2" sort="column2" width="501">
                                            <webuijsf:staticText binding="#{MainPage.staticText2}" id="staticText2" text="#{currentRow.value['column2']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </div>
                        </div>
                        <webuijsf:staticText binding="#{MainPage.id_News1}" id="id_News1"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; height: 118px; left: 216px; top: 408px; position: absolute; width: 502px" text="Hier könnten ihre News stehen ... und hier und hier und hier und hier und hier und hier und hier und hier und hier und hier und hier und hier und hier und hier und hier"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
