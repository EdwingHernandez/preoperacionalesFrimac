package com.frimac.preoperational.domain.dto;

public class UserTCDTO {

    private String idUserTC;
    private String nameUserTC;
    private boolean stateUserTC;
    private String operationUserTC;
    private String positionUserTC;
    private String sucursalUserTC;
    

    public UserTCDTO(String idUserTC, String nameUserTC, boolean stateUserTC, String operationUserTC, String positionUserTC,
        String sucursalUserTC) {
        this.idUserTC = idUserTC;
        this.nameUserTC = nameUserTC;
        this.stateUserTC = stateUserTC;
        this.operationUserTC = operationUserTC;
        this.positionUserTC = positionUserTC;
        this.sucursalUserTC = sucursalUserTC;
    }


    public String getIdUserTC() {
        return idUserTC;
    }


    public void setIdUserTC(String idUserTC) {
        this.idUserTC = idUserTC;
    }


    public String getNameUserTC() {
        return nameUserTC;
    }


    public void setNameUserTC(String nameUserTC) {
        this.nameUserTC = nameUserTC;
    }


    public String getOperationUserTC() {
        return operationUserTC;
    }


    public void setOperationUserTC(String operationUserTC) {
        this.operationUserTC = operationUserTC;
    }


    public String getPositionUserTC() {
        return positionUserTC;
    }


    public void setPositionUserTC(String positionUserTC) {
        this.positionUserTC = positionUserTC;
    }


    public String getSucursalUserTC() {
        return sucursalUserTC;
    }


    public void setSucursalUserTC(String sucursalUserTC) {
        this.sucursalUserTC = sucursalUserTC;
    }


    public boolean isStateUserTC() {
        return stateUserTC;
    }


    public void setStateUserTC(boolean stateUserTC) {
        this.stateUserTC = stateUserTC;
    }

    

}

// { '@odata.context': 'http://SPX/api/$metadata#Generic',
//   '@odata.count': 1,
//   value: 
//    [ { Id: 34876,
//        Ucr_Code: '1095792322',
//        UtyCode: 'CON',
//        UtyName: 'Conductor',
//        UxtExternalERPCode: '20981',
//        Ucr_Name: 'JOHN EDINSON JAIMES DOMINGUEZ',
//        IdentificationType: 'C',
//        UitName: 'Cédula de Ciudadanía',
//        Identification: '1095792322',
//        UcrReference: null,
//        State: 1,
//        UcrCarnetCode: null,
//        CarrierCode: null,
//        CarrierName: null,
//        MainEmailAddress: 'jhonjaimes2430@gmail.com',
//        Ucr_SocId: 53,
//        UxtId: 33643,
//        trafficIntegration: '',
//        UmaFbState: 1,
//        UmaIntegrationState: 3,
//        Country_CouCode: 'COL',
//        CityCitCode: '68001000',
//        FirstName: 'JOHN EDINSON',
//        LastName: 'JAIMES',
//        SecondLastName: 'DOMINGUEZ',
//        Address: null,
//        Birthday: null,
//        DriverProfile: null,
//        MainPhone: null,
//        UcrRegimenGimCode: 'RSIM',
//        UcrRndcSimpleRegimen: 0,
//        UcrSubsidiarySubCode: 'InHPlaFlo',
//        UcrBusinessOperationTypeBopCode: 'REFRI',
//        UcrPaymentTermsInvoicePytCode: 'INM',
//        AceCode: '4923' } ] }