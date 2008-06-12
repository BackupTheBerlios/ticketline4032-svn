<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainPage
    Created on : Apr 20, 2008, 6:08:44 PM
    Author     : Michael Morak
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{ManageAccount.page1}" id="page1">
            <webuijsf:html binding="#{ManageAccount.html1}" id="html1">
                <webuijsf:head binding="#{ManageAccount.head1}" id="head1">
                    <webuijsf:link binding="#{ManageAccount.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{ManageAccount.body1}" id="body1" style="-rave-layout: grid">
                    <div style="left: 0px; top: 0px; position: absolute">
                        <jsp:directive.include file="MasterFragment.jspf"/>
                    </div>
                    <webuijsf:form binding="#{ManageAccount.form1}" id="form1">
                        <div style="height: 478px; left: 192px; top: 120px; position: absolute; width: 750px">
                            <webuijsf:label binding="#{ManageAccount.labelTitle}" id="labelTitle"
                                style="height: 20px; left: 10px; top: 60px; position: absolute; width: 59px" text="Titel"/>
                            <webuijsf:textField binding="#{ManageAccount.textTitle}" id="textTitle" style="height: 20px; left: 160px; top: 60px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelForename}" id="labelForename"
                                style="height: 20px; left: 10px; top: 80px; position: absolute; width: 59px" text="Vorname"/>
                            <webuijsf:textField binding="#{ManageAccount.textForename}" id="textForename" style="height: 20px; left: 160px; top: 80px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelSurname}" id="labelSurname"
                                style="height: 20px; left: 10px; top: 100px; position: absolute; width: 59px" text="Nachname"/>
                            <webuijsf:textField binding="#{ManageAccount.textSurname}" id="textSurname" style="height: 20px; left: 160px; top: 100px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelBirth}" id="labelBirth"
                                style="height: 20px; left: 10px; top: 120px; position: absolute; width: 93px" text="Geburtsdatum"/>
                            <webuijsf:textField binding="#{ManageAccount.textBirth}" id="textBirth" style="height: 20px; left: 160px; top: 120px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelSex}" id="labelSex"
                                style="height: 20px; left: 10px; top: 140px; position: absolute; width: 69px" text="Geschlecht"/>
                            <webuijsf:radioButton binding="#{ManageAccount.radioMale}" id="radioMale" label="M" name="geschlecht" style="height: 20px; left: 160px; top: 140px; position: absolute; width: 57px"/>
                            <webuijsf:radioButton binding="#{ManageAccount.radioFemale}" id="radioFemale" label="W" name="geschlecht" style="height: 20px; left: 220px; top: 140px; position: absolute; width: 67px"/>
                            <webuijsf:label binding="#{ManageAccount.labelStreet}" id="labelStreet"
                                style="height: 20px; left: 10px; top: 160px; position: absolute; width: 59px" text="Straße"/>
                            <webuijsf:textField binding="#{ManageAccount.textStreet}" id="textStreet" style="height: 20px; left: 160px; top: 160px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelCity}" id="labelCity"
                                style="height: 20px; left: 10px; top: 180px; position: absolute; width: 59px" text="Ort"/>
                            <webuijsf:textField binding="#{ManageAccount.textCity}" id="textCity" style="height: 20px; left: 160px; top: 180px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelZIP}" id="labelZIP"
                                style="height: 20px; left: 10px; top: 200px; position: absolute; width: 45px" text="PLZ"/>
                            <webuijsf:textField binding="#{ManageAccount.textZIP}" id="textZIP" style="height: 20px; left: 160px; top: 200px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelPhone}" id="labelPhone"
                                style="height: 20px; left: 10px; top: 230px; position: absolute; width: 59px" text="Telefon"/>
                            <webuijsf:textField binding="#{ManageAccount.textPhone}" id="textPhone" style="height: 20px; left: 160px; top: 230px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelEmail}" id="labelEmail"
                                style="height: 20px; left: 10px; top: 250px; position: absolute; width: 59px" text="E-Mail"/>
                            <webuijsf:textField binding="#{ManageAccount.textEmail}" id="textEmail" style="height: 20px; left: 160px; top: 250px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelBankAccount}" id="labelBankAccount"
                                style="height: 20px; left: 10px; top: 280px; position: absolute; width: 93px" text="Kontonummer"/>
                            <webuijsf:textField binding="#{ManageAccount.textBankAccount}" id="textBankAccount" style="height: 20px; left: 160px; top: 280px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelBankNumber}" id="labelBankNumber"
                                style="height: 20px; left: 10px; top: 300px; position: absolute; width: 59px" text="BLZ"/>
                            <webuijsf:textField binding="#{ManageAccount.textBankNumber}" id="textBankNumber" style="height: 20px; left: 160px; top: 300px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelCreditCard}" id="labelCreditCard"
                                style="height: 20px; left: 10px; top: 330px; position: absolute; width: 93px" text="Kreditkarten-Nr."/>
                            <webuijsf:textField binding="#{ManageAccount.textCreditCard}" id="textCreditCard" style="height: 20px; left: 160px; top: 330px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelCreditCardValid}" id="labelCreditCardValid"
                                style="height: 20px; left: 10px; top: 350px; position: absolute; width: 117px" text="Kreditkarte gültig bis"/>
                            <webuijsf:textField binding="#{ManageAccount.textCreditCardValid}" id="textCreditCardValid" style="height: 20px; left: 160px; top: 350px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelLikes}" id="labelLikes"
                                style="height: 20px; left: 310px; top: 60px; position: absolute; width: 59px" text="Vorlieben"/>
                            <webuijsf:textArea binding="#{ManageAccount.textLikes}" id="textLikes" style="left: 460px; top: 60px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelPasswordNew}" id="labelPasswordNew"
                                style="height: 20px; left: 310px; top: 110px; position: absolute; width: 117px" text="Neues Passwort"/>
                            <webuijsf:passwordField binding="#{ManageAccount.passwordNew}" id="passwordNew" style="height: 20px; left: 460px; top: 110px; position: absolute; width: 117px"/>
                            <webuijsf:label binding="#{ManageAccount.labelPasswordRepeat}" id="labelPasswordRepeat"
                                style="height: 20px; left: 310px; top: 130px; position: absolute; width: 143px" text="Passwort wiederholen"/>
                            <webuijsf:passwordField binding="#{ManageAccount.passwordRepeat}" id="passwordRepeat" style="height: 20px; left: 460px; top: 130px; position: absolute; width: 117px"/>
                            <webuijsf:button actionExpression="#{ManageAccount.buttonSave_action}" binding="#{ManageAccount.buttonSave}" id="buttonSave"
                                style="height: 20px; left: 9px; top: 390px; position: absolute; width: 117px" text="Speichern"/>
                            <webuijsf:staticText binding="#{ManageAccount.staticTextMessage}" id="staticTextMessage" style="color: rgb(204, 0, 0); height: 77px; left: 160px; top: 390px; position: absolute; vertical-align: bottom; width: 577px"/>
                        </div>
                        <webuijsf:staticText binding="#{ManageAccount.staticTextTitle}" id="staticTextTitle"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; height: 46px; left: 200px; top: 130px; position: absolute; width: 214px" text="Account verwalten"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
