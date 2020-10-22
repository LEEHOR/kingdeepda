package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: PurchaseOrderAddBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/21 15:07
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/21 15:07
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseOrderAddBean implements Serializable {

    /**
     * NeedReturnFields : []
     * ValidateFlag : true
     * SubSystemId :
     * IsDeleteEntry : true
     * Model : {"FBillNo":"","FPurchaseOrgId":{"FNumber":""},"FSupplyAddress":"","FPurchaserGroupId":{"FNumber":""},"FInStockFin":{"FSettleCurrId":{"FNumber":""},"FPayConditionId":{"FNumber":""},"FDiscountListId":{"FNumber":""},"FLocalCurrId":{"FNumber":""},"FSettleOrgId":{"FNumber":""},"FEntryId":0,"FPriceListId":{"FNumber":""},"FISPRICEEXCLUDETAX":"false","FExchangeTypeId":{"FNumber":""},"FIsIncludedTax":"false","FPriceTimePoint":"","FExchangeRate":0,"FSettleTypeId":{"FNumber":""}},"FOwnerTypeIdHead":"","FCDateOffsetValue":0,"FOwnerIdHead":{"FNumber":""},"FDemandOrgId":{"FNumber":""},"FPurchaseDeptId":{"FNumber":""},"FConfirmerId":{"FUserID":""},"FConfirmDate":"1900-01-01","FStockDeptId":{"FNumber":""},"FScanBox":"","FPurchaserId":{"FNumber":""},"FID":0,"FSplitBillType":"","FStockOrgId":{"FNumber":""},"FProviderContactID":{"FCONTACTNUMBER":""},"FCDateOffsetUnit":"","FDate":"1900-01-01","FCorrespondOrgId":{"FNumber":""},"FStockerGroupId":{"FNumber":""},"FSupplierId":{"FNumber":""},"FInStockEntry":[{"FStockStatusId":{"FNumber":""},"FEntryPruCost":[{"FDetailID":0}],"F_PBXQ_Project":{"FNUMBER":""},"FPriceBaseQty":0,"FMtoNo":"","FWWInType":"","FEntryID":0,"FLot":{"FNumber":""},"FPriceDiscount":0,"FParentMatId":{"FNUMBER":""},"FStockLocId":{},"FOWNERID":{"FNumber":""},"FSerialSubEntity":[{"FSerialNo":"","FDetailID":0,"FSerialNote":""}],"FConsumeSumQty":0,"FTaxDetailSubEntity":[{"FTaxRate":0,"FDetailID":0}],"FRealQty":0,"FPriceUnitID":{"FNumber":""},"FProjectNo":"","FGiveAway":"false","FNote":"","FBeforeDisPriceQty":0,"FPrice":0,"FProduceDate":"1900-01-01","FAuxUnitQty":0,"FUnitID":{"FNumber":""},"FAPNotJoinQty":0,"FEntryTaxRate":0,"FExpiryDate":"1900-01-01","FBaseConsumeSumQty":0,"FCostPrice":0,"FAuxPropId":{"FAUXPROPID__FF100001":{"FNumber":""}},"FCheckInComing":"false","FDisPriceQty":0,"FExtAuxUnitId":{"FNumber":""},"FRemainInStockQty":0,"FIsReceiveUpdateStock":"false","FStockId":{"FNumber":""},"FTaxCombination":{"FNumber":""},"FMaterialId":{"FNumber":""},"FSetPriceUnitID":{"FNumber":""},"FInvoicedJoinQty":0,"FRemainInStockBaseQty":0,"FOWNERTYPEID":"","FBILLINGCLOSE":"false","FBOMId":{"FNumber":""},"FSupplierLot":"","FExtAuxUnitQty":0,"FTaxPrice":0,"FRemainInStockUnitId":{"FNumber":""},"FDiscountRate":0,"FRowType":""}],"FSettleId":{"FNumber":""},"FBillTypeID":{"FNUMBER":""},"FStockerId":{"FNumber":""},"FSupplyId":{"FNumber":""},"FChargeId":{"FNumber":""}}
     * NeedUpDateFields : []
     * IsVerifyBaseDataField : false
     * IsEntryBatchFill : true
     * NumberSearch : true
     * InterationFlags :
     */
    private List<?> NeedReturnFields;
    private String ValidateFlag;
    private String SubSystemId;
    private String IsDeleteEntry;
    private ModelEntity Model;
    private List<?> NeedUpDateFields;
    private String IsVerifyBaseDataField;
    private String IsEntryBatchFill;
    private String NumberSearch;
    private String InterationFlags;

    public void setNeedReturnFields(List<?> NeedReturnFields) {
        this.NeedReturnFields = NeedReturnFields;
    }

    public void setValidateFlag(String ValidateFlag) {
        this.ValidateFlag = ValidateFlag;
    }

    public void setSubSystemId(String SubSystemId) {
        this.SubSystemId = SubSystemId;
    }

    public void setIsDeleteEntry(String IsDeleteEntry) {
        this.IsDeleteEntry = IsDeleteEntry;
    }

    public void setModel(ModelEntity Model) {
        this.Model = Model;
    }

    public void setNeedUpDateFields(List<?> NeedUpDateFields) {
        this.NeedUpDateFields = NeedUpDateFields;
    }

    public void setIsVerifyBaseDataField(String IsVerifyBaseDataField) {
        this.IsVerifyBaseDataField = IsVerifyBaseDataField;
    }

    public void setIsEntryBatchFill(String IsEntryBatchFill) {
        this.IsEntryBatchFill = IsEntryBatchFill;
    }

    public void setNumberSearch(String NumberSearch) {
        this.NumberSearch = NumberSearch;
    }

    public void setInterationFlags(String InterationFlags) {
        this.InterationFlags = InterationFlags;
    }

    public List<?> getNeedReturnFields() {
        return NeedReturnFields;
    }

    public String getValidateFlag() {
        return ValidateFlag;
    }

    public String getSubSystemId() {
        return SubSystemId;
    }

    public String getIsDeleteEntry() {
        return IsDeleteEntry;
    }

    public ModelEntity getModel() {
        return Model;
    }

    public List<?> getNeedUpDateFields() {
        return NeedUpDateFields;
    }

    public String getIsVerifyBaseDataField() {
        return IsVerifyBaseDataField;
    }

    public String getIsEntryBatchFill() {
        return IsEntryBatchFill;
    }

    public String getNumberSearch() {
        return NumberSearch;
    }

    public String getInterationFlags() {
        return InterationFlags;
    }

    public static class ModelEntity {
        /**
         * FBillNo :
         * FPurchaseOrgId : {"FNumber":""}
         * FSupplyAddress :
         * FPurchaserGroupId : {"FNumber":""}
         * FInStockFin : {"FSettleCurrId":{"FNumber":""},"FPayConditionId":{"FNumber":""},"FDiscountListId":{"FNumber":""},"FLocalCurrId":{"FNumber":""},"FSettleOrgId":{"FNumber":""},"FEntryId":0,"FPriceListId":{"FNumber":""},"FISPRICEEXCLUDETAX":"false","FExchangeTypeId":{"FNumber":""},"FIsIncludedTax":"false","FPriceTimePoint":"","FExchangeRate":0,"FSettleTypeId":{"FNumber":""}}
         * FOwnerTypeIdHead :
         * FCDateOffsetValue : 0
         * FOwnerIdHead : {"FNumber":""}
         * FDemandOrgId : {"FNumber":""}
         * FPurchaseDeptId : {"FNumber":""}
         * FConfirmerId : {"FUserID":""}
         * FConfirmDate : 1900-01-01
         * FStockDeptId : {"FNumber":""}
         * FScanBox :
         * FPurchaserId : {"FNumber":""}
         * FID : 0
         * FSplitBillType :
         * FStockOrgId : {"FNumber":""}
         * FProviderContactID : {"FCONTACTNUMBER":""}
         * FCDateOffsetUnit :
         * FDate : 1900-01-01
         * FCorrespondOrgId : {"FNumber":""}
         * FStockerGroupId : {"FNumber":""}
         * FSupplierId : {"FNumber":""}
         * FInStockEntry : [{"FStockStatusId":{"FNumber":""},"FEntryPruCost":[{"FDetailID":0}],"F_PBXQ_Project":{"FNUMBER":""},"FPriceBaseQty":0,"FMtoNo":"","FWWInType":"","FEntryID":0,"FLot":{"FNumber":""},"FPriceDiscount":0,"FParentMatId":{"FNUMBER":""},"FStockLocId":{},"FOWNERID":{"FNumber":""},"FSerialSubEntity":[{"FSerialNo":"","FDetailID":0,"FSerialNote":""}],"FConsumeSumQty":0,"FTaxDetailSubEntity":[{"FTaxRate":0,"FDetailID":0}],"FRealQty":0,"FPriceUnitID":{"FNumber":""},"FProjectNo":"","FGiveAway":"false","FNote":"","FBeforeDisPriceQty":0,"FPrice":0,"FProduceDate":"1900-01-01","FAuxUnitQty":0,"FUnitID":{"FNumber":""},"FAPNotJoinQty":0,"FEntryTaxRate":0,"FExpiryDate":"1900-01-01","FBaseConsumeSumQty":0,"FCostPrice":0,"FAuxPropId":{"FAUXPROPID__FF100001":{"FNumber":""}},"FCheckInComing":"false","FDisPriceQty":0,"FExtAuxUnitId":{"FNumber":""},"FRemainInStockQty":0,"FIsReceiveUpdateStock":"false","FStockId":{"FNumber":""},"FTaxCombination":{"FNumber":""},"FMaterialId":{"FNumber":""},"FSetPriceUnitID":{"FNumber":""},"FInvoicedJoinQty":0,"FRemainInStockBaseQty":0,"FOWNERTYPEID":"","FBILLINGCLOSE":"false","FBOMId":{"FNumber":""},"FSupplierLot":"","FExtAuxUnitQty":0,"FTaxPrice":0,"FRemainInStockUnitId":{"FNumber":""},"FDiscountRate":0,"FRowType":""}]
         * FSettleId : {"FNumber":""}
         * FBillTypeID : {"FNUMBER":""}
         * FStockerId : {"FNumber":""}
         * FSupplyId : {"FNumber":""}
         * FChargeId : {"FNumber":""}
         */
        private String FBillNo;
        private FPurchaseOrgIdEntity FPurchaseOrgId;
        private String FSupplyAddress;
        private FPurchaserGroupIdEntity FPurchaserGroupId;
        private FInStockFinEntity FInStockFin;
        private String FOwnerTypeIdHead;
        private int FCDateOffsetValue;
        private FOwnerIdHeadEntity FOwnerIdHead;
        private FDemandOrgIdEntity FDemandOrgId;
        private FPurchaseDeptIdEntity FPurchaseDeptId;
        private FConfirmerIdEntity FConfirmerId;
        private String FConfirmDate;
        private FStockDeptIdEntity FStockDeptId;
        private String FScanBox;
        private FPurchaserIdEntity FPurchaserId;
        private int FID;
        private String FSplitBillType;
        private FStockOrgIdEntity FStockOrgId;
        private FProviderContactIDEntity FProviderContactID;
        private String FCDateOffsetUnit;
        private String FDate;
        private FCorrespondOrgIdEntity FCorrespondOrgId;
        private FStockerGroupIdEntity FStockerGroupId;
        private FSupplierIdEntity FSupplierId;
        private List<FInStockEntryEntity> FInStockEntry;
        private FSettleIdEntity FSettleId;
        private FBillTypeIDEntity FBillTypeID;
        private FStockerIdEntity FStockerId;
        private FSupplyIdEntity FSupplyId;
        private FChargeIdEntity FChargeId;

        public void setFBillNo(String FBillNo) {
            this.FBillNo = FBillNo;
        }

        public void setFPurchaseOrgId(FPurchaseOrgIdEntity FPurchaseOrgId) {
            this.FPurchaseOrgId = FPurchaseOrgId;
        }

        public void setFSupplyAddress(String FSupplyAddress) {
            this.FSupplyAddress = FSupplyAddress;
        }

        public void setFPurchaserGroupId(FPurchaserGroupIdEntity FPurchaserGroupId) {
            this.FPurchaserGroupId = FPurchaserGroupId;
        }

        public void setFInStockFin(FInStockFinEntity FInStockFin) {
            this.FInStockFin = FInStockFin;
        }

        public void setFOwnerTypeIdHead(String FOwnerTypeIdHead) {
            this.FOwnerTypeIdHead = FOwnerTypeIdHead;
        }

        public void setFCDateOffsetValue(int FCDateOffsetValue) {
            this.FCDateOffsetValue = FCDateOffsetValue;
        }

        public void setFOwnerIdHead(FOwnerIdHeadEntity FOwnerIdHead) {
            this.FOwnerIdHead = FOwnerIdHead;
        }

        public void setFDemandOrgId(FDemandOrgIdEntity FDemandOrgId) {
            this.FDemandOrgId = FDemandOrgId;
        }

        public void setFPurchaseDeptId(FPurchaseDeptIdEntity FPurchaseDeptId) {
            this.FPurchaseDeptId = FPurchaseDeptId;
        }

        public void setFConfirmerId(FConfirmerIdEntity FConfirmerId) {
            this.FConfirmerId = FConfirmerId;
        }

        public void setFConfirmDate(String FConfirmDate) {
            this.FConfirmDate = FConfirmDate;
        }

        public void setFStockDeptId(FStockDeptIdEntity FStockDeptId) {
            this.FStockDeptId = FStockDeptId;
        }

        public void setFScanBox(String FScanBox) {
            this.FScanBox = FScanBox;
        }

        public void setFPurchaserId(FPurchaserIdEntity FPurchaserId) {
            this.FPurchaserId = FPurchaserId;
        }

        public void setFID(int FID) {
            this.FID = FID;
        }

        public void setFSplitBillType(String FSplitBillType) {
            this.FSplitBillType = FSplitBillType;
        }

        public void setFStockOrgId(FStockOrgIdEntity FStockOrgId) {
            this.FStockOrgId = FStockOrgId;
        }

        public void setFProviderContactID(FProviderContactIDEntity FProviderContactID) {
            this.FProviderContactID = FProviderContactID;
        }

        public void setFCDateOffsetUnit(String FCDateOffsetUnit) {
            this.FCDateOffsetUnit = FCDateOffsetUnit;
        }

        public void setFDate(String FDate) {
            this.FDate = FDate;
        }

        public void setFCorrespondOrgId(FCorrespondOrgIdEntity FCorrespondOrgId) {
            this.FCorrespondOrgId = FCorrespondOrgId;
        }

        public void setFStockerGroupId(FStockerGroupIdEntity FStockerGroupId) {
            this.FStockerGroupId = FStockerGroupId;
        }

        public void setFSupplierId(FSupplierIdEntity FSupplierId) {
            this.FSupplierId = FSupplierId;
        }

        public void setFInStockEntry(List<FInStockEntryEntity> FInStockEntry) {
            this.FInStockEntry = FInStockEntry;
        }

        public void setFSettleId(FSettleIdEntity FSettleId) {
            this.FSettleId = FSettleId;
        }

        public void setFBillTypeID(FBillTypeIDEntity FBillTypeID) {
            this.FBillTypeID = FBillTypeID;
        }

        public void setFStockerId(FStockerIdEntity FStockerId) {
            this.FStockerId = FStockerId;
        }

        public void setFSupplyId(FSupplyIdEntity FSupplyId) {
            this.FSupplyId = FSupplyId;
        }

        public void setFChargeId(FChargeIdEntity FChargeId) {
            this.FChargeId = FChargeId;
        }

        public String getFBillNo() {
            return FBillNo;
        }

        public FPurchaseOrgIdEntity getFPurchaseOrgId() {
            return FPurchaseOrgId;
        }

        public String getFSupplyAddress() {
            return FSupplyAddress;
        }

        public FPurchaserGroupIdEntity getFPurchaserGroupId() {
            return FPurchaserGroupId;
        }

        public FInStockFinEntity getFInStockFin() {
            return FInStockFin;
        }

        public String getFOwnerTypeIdHead() {
            return FOwnerTypeIdHead;
        }

        public int getFCDateOffsetValue() {
            return FCDateOffsetValue;
        }

        public FOwnerIdHeadEntity getFOwnerIdHead() {
            return FOwnerIdHead;
        }

        public FDemandOrgIdEntity getFDemandOrgId() {
            return FDemandOrgId;
        }

        public FPurchaseDeptIdEntity getFPurchaseDeptId() {
            return FPurchaseDeptId;
        }

        public FConfirmerIdEntity getFConfirmerId() {
            return FConfirmerId;
        }

        public String getFConfirmDate() {
            return FConfirmDate;
        }

        public FStockDeptIdEntity getFStockDeptId() {
            return FStockDeptId;
        }

        public String getFScanBox() {
            return FScanBox;
        }

        public FPurchaserIdEntity getFPurchaserId() {
            return FPurchaserId;
        }

        public int getFID() {
            return FID;
        }

        public String getFSplitBillType() {
            return FSplitBillType;
        }

        public FStockOrgIdEntity getFStockOrgId() {
            return FStockOrgId;
        }

        public FProviderContactIDEntity getFProviderContactID() {
            return FProviderContactID;
        }

        public String getFCDateOffsetUnit() {
            return FCDateOffsetUnit;
        }

        public String getFDate() {
            return FDate;
        }

        public FCorrespondOrgIdEntity getFCorrespondOrgId() {
            return FCorrespondOrgId;
        }

        public FStockerGroupIdEntity getFStockerGroupId() {
            return FStockerGroupId;
        }

        public FSupplierIdEntity getFSupplierId() {
            return FSupplierId;
        }

        public List<FInStockEntryEntity> getFInStockEntry() {
            return FInStockEntry;
        }

        public FSettleIdEntity getFSettleId() {
            return FSettleId;
        }

        public FBillTypeIDEntity getFBillTypeID() {
            return FBillTypeID;
        }

        public FStockerIdEntity getFStockerId() {
            return FStockerId;
        }

        public FSupplyIdEntity getFSupplyId() {
            return FSupplyId;
        }

        public FChargeIdEntity getFChargeId() {
            return FChargeId;
        }

        public static class FPurchaseOrgIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FPurchaserGroupIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public class FInStockFinEntity {
            /**
             * FSettleCurrId : {"FNumber":""}
             * FPayConditionId : {"FNumber":""}
             * FDiscountListId : {"FNumber":""}
             * FLocalCurrId : {"FNumber":""}
             * FSettleOrgId : {"FNumber":""}
             * FEntryId : 0
             * FPriceListId : {"FNumber":""}
             * FISPRICEEXCLUDETAX : false
             * FExchangeTypeId : {"FNumber":""}
             * FIsIncludedTax : false
             * FPriceTimePoint :
             * FExchangeRate : 0
             * FSettleTypeId : {"FNumber":""}
             */
            private FSettleCurrIdEntity FSettleCurrId;
            private FPayConditionIdEntity FPayConditionId;
            private FDiscountListIdEntity FDiscountListId;
            private FLocalCurrIdEntity FLocalCurrId;
            private FSettleOrgIdEntity FSettleOrgId;
            private int FEntryId;
            private FPriceListIdEntity FPriceListId;
            private String FISPRICEEXCLUDETAX;
            private FExchangeTypeIdEntity FExchangeTypeId;
            private String FIsIncludedTax;
            private String FPriceTimePoint;
            private int FExchangeRate;
            private FSettleTypeIdEntity FSettleTypeId;

            public void setFSettleCurrId(FSettleCurrIdEntity FSettleCurrId) {
                this.FSettleCurrId = FSettleCurrId;
            }

            public void setFPayConditionId(FPayConditionIdEntity FPayConditionId) {
                this.FPayConditionId = FPayConditionId;
            }

            public void setFDiscountListId(FDiscountListIdEntity FDiscountListId) {
                this.FDiscountListId = FDiscountListId;
            }

            public void setFLocalCurrId(FLocalCurrIdEntity FLocalCurrId) {
                this.FLocalCurrId = FLocalCurrId;
            }

            public void setFSettleOrgId(FSettleOrgIdEntity FSettleOrgId) {
                this.FSettleOrgId = FSettleOrgId;
            }

            public void setFEntryId(int FEntryId) {
                this.FEntryId = FEntryId;
            }

            public void setFPriceListId(FPriceListIdEntity FPriceListId) {
                this.FPriceListId = FPriceListId;
            }

            public void setFISPRICEEXCLUDETAX(String FISPRICEEXCLUDETAX) {
                this.FISPRICEEXCLUDETAX = FISPRICEEXCLUDETAX;
            }

            public void setFExchangeTypeId(FExchangeTypeIdEntity FExchangeTypeId) {
                this.FExchangeTypeId = FExchangeTypeId;
            }

            public void setFIsIncludedTax(String FIsIncludedTax) {
                this.FIsIncludedTax = FIsIncludedTax;
            }

            public void setFPriceTimePoint(String FPriceTimePoint) {
                this.FPriceTimePoint = FPriceTimePoint;
            }

            public void setFExchangeRate(int FExchangeRate) {
                this.FExchangeRate = FExchangeRate;
            }

            public void setFSettleTypeId(FSettleTypeIdEntity FSettleTypeId) {
                this.FSettleTypeId = FSettleTypeId;
            }

            public FSettleCurrIdEntity getFSettleCurrId() {
                return FSettleCurrId;
            }

            public FPayConditionIdEntity getFPayConditionId() {
                return FPayConditionId;
            }

            public FDiscountListIdEntity getFDiscountListId() {
                return FDiscountListId;
            }

            public FLocalCurrIdEntity getFLocalCurrId() {
                return FLocalCurrId;
            }

            public FSettleOrgIdEntity getFSettleOrgId() {
                return FSettleOrgId;
            }

            public int getFEntryId() {
                return FEntryId;
            }

            public FPriceListIdEntity getFPriceListId() {
                return FPriceListId;
            }

            public String getFISPRICEEXCLUDETAX() {
                return FISPRICEEXCLUDETAX;
            }

            public FExchangeTypeIdEntity getFExchangeTypeId() {
                return FExchangeTypeId;
            }

            public String getFIsIncludedTax() {
                return FIsIncludedTax;
            }

            public String getFPriceTimePoint() {
                return FPriceTimePoint;
            }

            public int getFExchangeRate() {
                return FExchangeRate;
            }

            public FSettleTypeIdEntity getFSettleTypeId() {
                return FSettleTypeId;
            }

            public class FSettleCurrIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FPayConditionIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FDiscountListIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FLocalCurrIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FSettleOrgIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FPriceListIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FExchangeTypeIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FSettleTypeIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }
        }

        public static class FOwnerIdHeadEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FDemandOrgIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FPurchaseDeptIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public class FConfirmerIdEntity {
            /**
             * FUserID :
             */
            private String FUserID;

            public void setFUserID(String FUserID) {
                this.FUserID = FUserID;
            }

            public String getFUserID() {
                return FUserID;
            }
        }

        public static class FStockDeptIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public class FPurchaserIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FStockOrgIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public class FProviderContactIDEntity {
            /**
             * FCONTACTNUMBER :
             */
            private String FCONTACTNUMBER;

            public void setFCONTACTNUMBER(String FCONTACTNUMBER) {
                this.FCONTACTNUMBER = FCONTACTNUMBER;
            }

            public String getFCONTACTNUMBER() {
                return FCONTACTNUMBER;
            }
        }

        public static class FCorrespondOrgIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FStockerGroupIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FSupplierIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FInStockEntryEntity {
            /**
             * FStockStatusId : {"FNumber":""}
             * FEntryPruCost : [{"FDetailID":0}]
             * F_PBXQ_Project : {"FNUMBER":""}
             * FPriceBaseQty : 0
             * FMtoNo :
             * FWWInType :
             * FEntryID : 0
             * FLot : {"FNumber":""}
             * FPriceDiscount : 0
             * FParentMatId : {"FNUMBER":""}
             * FStockLocId : {}
             * FOWNERID : {"FNumber":""}
             * FSerialSubEntity : [{"FSerialNo":"","FDetailID":0,"FSerialNote":""}]
             * FConsumeSumQty : 0
             * FTaxDetailSubEntity : [{"FTaxRate":0,"FDetailID":0}]
             * FRealQty : 0
             * FPriceUnitID : {"FNumber":""}
             * FProjectNo :
             * FGiveAway : false
             * FNote :
             * FBeforeDisPriceQty : 0
             * FPrice : 0
             * FProduceDate : 1900-01-01
             * FAuxUnitQty : 0
             * FUnitID : {"FNumber":""}
             * FAPNotJoinQty : 0
             * FEntryTaxRate : 0
             * FExpiryDate : 1900-01-01
             * FBaseConsumeSumQty : 0
             * FCostPrice : 0
             * FAuxPropId : {"FAUXPROPID__FF100001":{"FNumber":""}}
             * FCheckInComing : false
             * FDisPriceQty : 0
             * FExtAuxUnitId : {"FNumber":""}
             * FRemainInStockQty : 0
             * FIsReceiveUpdateStock : false
             * FStockId : {"FNumber":""}
             * FTaxCombination : {"FNumber":""}
             * FMaterialId : {"FNumber":""}
             * FSetPriceUnitID : {"FNumber":""}
             * FInvoicedJoinQty : 0
             * FRemainInStockBaseQty : 0
             * FOWNERTYPEID :
             * FBILLINGCLOSE : false
             * FBOMId : {"FNumber":""}
             * FSupplierLot :
             * FExtAuxUnitQty : 0
             * FTaxPrice : 0
             * FRemainInStockUnitId : {"FNumber":""}
             * FDiscountRate : 0
             * FRowType :
             */
            private FStockStatusIdEntity FStockStatusId;
            private List<FEntryPruCostEntity> FEntryPruCost;
            private F_PBXQ_ProjectEntity F_PBXQ_Project;
            private int FPriceBaseQty;
            private String FMtoNo;
            private String FWWInType;
            private int FEntryID;
            private FLotEntity FLot;
            private int FPriceDiscount;
            private FParentMatIdEntity FParentMatId;
            private FStockLocIdEntity FStockLocId;
            private FOWNERIDEntity FOWNERID;
            private List<FSerialSubEntityEntity> FSerialSubEntity;
            private int FConsumeSumQty;
            private List<FTaxDetailSubEntityEntity> FTaxDetailSubEntity;
            private int FRealQty;
            private FPriceUnitIDEntity FPriceUnitID;
            private String FProjectNo;
            private String FGiveAway;
            private String FNote;
            private int FBeforeDisPriceQty;
            private int FPrice;
            private String FProduceDate;
            private int FAuxUnitQty;
            private FUnitIDEntity FUnitID;
            private int FAPNotJoinQty;
            private int FEntryTaxRate;
            private String FExpiryDate;
            private int FBaseConsumeSumQty;
            private int FCostPrice;
            private FAuxPropIdEntity FAuxPropId;
            private String FCheckInComing;
            private int FDisPriceQty;
            private FExtAuxUnitIdEntity FExtAuxUnitId;
            private int FRemainInStockQty;
            private String FIsReceiveUpdateStock;
            private FStockIdEntity FStockId;
            private FTaxCombinationEntity FTaxCombination;
            private FMaterialIdEntity FMaterialId;
            private FSetPriceUnitIDEntity FSetPriceUnitID;
            private int FInvoicedJoinQty;
            private int FRemainInStockBaseQty;
            private String FOWNERTYPEID;
            private String FBILLINGCLOSE;
            private FBOMIdEntity FBOMId;
            private String FSupplierLot;
            private int FExtAuxUnitQty;
            private int FTaxPrice;
            private FRemainInStockUnitIdEntity FRemainInStockUnitId;
            private int FDiscountRate;
            private String FRowType;

            public void setFStockStatusId(FStockStatusIdEntity FStockStatusId) {
                this.FStockStatusId = FStockStatusId;
            }

            public void setFEntryPruCost(List<FEntryPruCostEntity> FEntryPruCost) {
                this.FEntryPruCost = FEntryPruCost;
            }

            public void setF_PBXQ_Project(F_PBXQ_ProjectEntity F_PBXQ_Project) {
                this.F_PBXQ_Project = F_PBXQ_Project;
            }

            public void setFPriceBaseQty(int FPriceBaseQty) {
                this.FPriceBaseQty = FPriceBaseQty;
            }

            public void setFMtoNo(String FMtoNo) {
                this.FMtoNo = FMtoNo;
            }

            public void setFWWInType(String FWWInType) {
                this.FWWInType = FWWInType;
            }

            public void setFEntryID(int FEntryID) {
                this.FEntryID = FEntryID;
            }

            public void setFLot(FLotEntity FLot) {
                this.FLot = FLot;
            }

            public void setFPriceDiscount(int FPriceDiscount) {
                this.FPriceDiscount = FPriceDiscount;
            }

            public void setFParentMatId(FParentMatIdEntity FParentMatId) {
                this.FParentMatId = FParentMatId;
            }

            public void setFStockLocId(FStockLocIdEntity FStockLocId) {
                this.FStockLocId = FStockLocId;
            }

            public void setFOWNERID(FOWNERIDEntity FOWNERID) {
                this.FOWNERID = FOWNERID;
            }

            public void setFSerialSubEntity(List<FSerialSubEntityEntity> FSerialSubEntity) {
                this.FSerialSubEntity = FSerialSubEntity;
            }

            public void setFConsumeSumQty(int FConsumeSumQty) {
                this.FConsumeSumQty = FConsumeSumQty;
            }

            public void setFTaxDetailSubEntity(List<FTaxDetailSubEntityEntity> FTaxDetailSubEntity) {
                this.FTaxDetailSubEntity = FTaxDetailSubEntity;
            }

            public void setFRealQty(int FRealQty) {
                this.FRealQty = FRealQty;
            }

            public void setFPriceUnitID(FPriceUnitIDEntity FPriceUnitID) {
                this.FPriceUnitID = FPriceUnitID;
            }

            public void setFProjectNo(String FProjectNo) {
                this.FProjectNo = FProjectNo;
            }

            public void setFGiveAway(String FGiveAway) {
                this.FGiveAway = FGiveAway;
            }

            public void setFNote(String FNote) {
                this.FNote = FNote;
            }

            public void setFBeforeDisPriceQty(int FBeforeDisPriceQty) {
                this.FBeforeDisPriceQty = FBeforeDisPriceQty;
            }

            public void setFPrice(int FPrice) {
                this.FPrice = FPrice;
            }

            public void setFProduceDate(String FProduceDate) {
                this.FProduceDate = FProduceDate;
            }

            public void setFAuxUnitQty(int FAuxUnitQty) {
                this.FAuxUnitQty = FAuxUnitQty;
            }

            public void setFUnitID(FUnitIDEntity FUnitID) {
                this.FUnitID = FUnitID;
            }

            public void setFAPNotJoinQty(int FAPNotJoinQty) {
                this.FAPNotJoinQty = FAPNotJoinQty;
            }

            public void setFEntryTaxRate(int FEntryTaxRate) {
                this.FEntryTaxRate = FEntryTaxRate;
            }

            public void setFExpiryDate(String FExpiryDate) {
                this.FExpiryDate = FExpiryDate;
            }

            public void setFBaseConsumeSumQty(int FBaseConsumeSumQty) {
                this.FBaseConsumeSumQty = FBaseConsumeSumQty;
            }

            public void setFCostPrice(int FCostPrice) {
                this.FCostPrice = FCostPrice;
            }

            public void setFAuxPropId(FAuxPropIdEntity FAuxPropId) {
                this.FAuxPropId = FAuxPropId;
            }

            public void setFCheckInComing(String FCheckInComing) {
                this.FCheckInComing = FCheckInComing;
            }

            public void setFDisPriceQty(int FDisPriceQty) {
                this.FDisPriceQty = FDisPriceQty;
            }

            public void setFExtAuxUnitId(FExtAuxUnitIdEntity FExtAuxUnitId) {
                this.FExtAuxUnitId = FExtAuxUnitId;
            }

            public void setFRemainInStockQty(int FRemainInStockQty) {
                this.FRemainInStockQty = FRemainInStockQty;
            }

            public void setFIsReceiveUpdateStock(String FIsReceiveUpdateStock) {
                this.FIsReceiveUpdateStock = FIsReceiveUpdateStock;
            }

            public void setFStockId(FStockIdEntity FStockId) {
                this.FStockId = FStockId;
            }

            public void setFTaxCombination(FTaxCombinationEntity FTaxCombination) {
                this.FTaxCombination = FTaxCombination;
            }

            public void setFMaterialId(FMaterialIdEntity FMaterialId) {
                this.FMaterialId = FMaterialId;
            }

            public void setFSetPriceUnitID(FSetPriceUnitIDEntity FSetPriceUnitID) {
                this.FSetPriceUnitID = FSetPriceUnitID;
            }

            public void setFInvoicedJoinQty(int FInvoicedJoinQty) {
                this.FInvoicedJoinQty = FInvoicedJoinQty;
            }

            public void setFRemainInStockBaseQty(int FRemainInStockBaseQty) {
                this.FRemainInStockBaseQty = FRemainInStockBaseQty;
            }

            public void setFOWNERTYPEID(String FOWNERTYPEID) {
                this.FOWNERTYPEID = FOWNERTYPEID;
            }

            public void setFBILLINGCLOSE(String FBILLINGCLOSE) {
                this.FBILLINGCLOSE = FBILLINGCLOSE;
            }

            public void setFBOMId(FBOMIdEntity FBOMId) {
                this.FBOMId = FBOMId;
            }

            public void setFSupplierLot(String FSupplierLot) {
                this.FSupplierLot = FSupplierLot;
            }

            public void setFExtAuxUnitQty(int FExtAuxUnitQty) {
                this.FExtAuxUnitQty = FExtAuxUnitQty;
            }

            public void setFTaxPrice(int FTaxPrice) {
                this.FTaxPrice = FTaxPrice;
            }

            public void setFRemainInStockUnitId(FRemainInStockUnitIdEntity FRemainInStockUnitId) {
                this.FRemainInStockUnitId = FRemainInStockUnitId;
            }

            public void setFDiscountRate(int FDiscountRate) {
                this.FDiscountRate = FDiscountRate;
            }

            public void setFRowType(String FRowType) {
                this.FRowType = FRowType;
            }

            public FStockStatusIdEntity getFStockStatusId() {
                return FStockStatusId;
            }

            public List<FEntryPruCostEntity> getFEntryPruCost() {
                return FEntryPruCost;
            }

            public F_PBXQ_ProjectEntity getF_PBXQ_Project() {
                return F_PBXQ_Project;
            }

            public int getFPriceBaseQty() {
                return FPriceBaseQty;
            }

            public String getFMtoNo() {
                return FMtoNo;
            }

            public String getFWWInType() {
                return FWWInType;
            }

            public int getFEntryID() {
                return FEntryID;
            }

            public FLotEntity getFLot() {
                return FLot;
            }

            public int getFPriceDiscount() {
                return FPriceDiscount;
            }

            public FParentMatIdEntity getFParentMatId() {
                return FParentMatId;
            }

            public FStockLocIdEntity getFStockLocId() {
                return FStockLocId;
            }

            public FOWNERIDEntity getFOWNERID() {
                return FOWNERID;
            }

            public List<FSerialSubEntityEntity> getFSerialSubEntity() {
                return FSerialSubEntity;
            }

            public int getFConsumeSumQty() {
                return FConsumeSumQty;
            }

            public List<FTaxDetailSubEntityEntity> getFTaxDetailSubEntity() {
                return FTaxDetailSubEntity;
            }

            public int getFRealQty() {
                return FRealQty;
            }

            public FPriceUnitIDEntity getFPriceUnitID() {
                return FPriceUnitID;
            }

            public String getFProjectNo() {
                return FProjectNo;
            }

            public String getFGiveAway() {
                return FGiveAway;
            }

            public String getFNote() {
                return FNote;
            }

            public int getFBeforeDisPriceQty() {
                return FBeforeDisPriceQty;
            }

            public int getFPrice() {
                return FPrice;
            }

            public String getFProduceDate() {
                return FProduceDate;
            }

            public int getFAuxUnitQty() {
                return FAuxUnitQty;
            }

            public FUnitIDEntity getFUnitID() {
                return FUnitID;
            }

            public int getFAPNotJoinQty() {
                return FAPNotJoinQty;
            }

            public int getFEntryTaxRate() {
                return FEntryTaxRate;
            }

            public String getFExpiryDate() {
                return FExpiryDate;
            }

            public int getFBaseConsumeSumQty() {
                return FBaseConsumeSumQty;
            }

            public int getFCostPrice() {
                return FCostPrice;
            }

            public FAuxPropIdEntity getFAuxPropId() {
                return FAuxPropId;
            }

            public String getFCheckInComing() {
                return FCheckInComing;
            }

            public int getFDisPriceQty() {
                return FDisPriceQty;
            }

            public FExtAuxUnitIdEntity getFExtAuxUnitId() {
                return FExtAuxUnitId;
            }

            public int getFRemainInStockQty() {
                return FRemainInStockQty;
            }

            public String getFIsReceiveUpdateStock() {
                return FIsReceiveUpdateStock;
            }

            public FStockIdEntity getFStockId() {
                return FStockId;
            }

            public FTaxCombinationEntity getFTaxCombination() {
                return FTaxCombination;
            }

            public FMaterialIdEntity getFMaterialId() {
                return FMaterialId;
            }

            public FSetPriceUnitIDEntity getFSetPriceUnitID() {
                return FSetPriceUnitID;
            }

            public int getFInvoicedJoinQty() {
                return FInvoicedJoinQty;
            }

            public int getFRemainInStockBaseQty() {
                return FRemainInStockBaseQty;
            }

            public String getFOWNERTYPEID() {
                return FOWNERTYPEID;
            }

            public String getFBILLINGCLOSE() {
                return FBILLINGCLOSE;
            }

            public FBOMIdEntity getFBOMId() {
                return FBOMId;
            }

            public String getFSupplierLot() {
                return FSupplierLot;
            }

            public int getFExtAuxUnitQty() {
                return FExtAuxUnitQty;
            }

            public int getFTaxPrice() {
                return FTaxPrice;
            }

            public FRemainInStockUnitIdEntity getFRemainInStockUnitId() {
                return FRemainInStockUnitId;
            }

            public int getFDiscountRate() {
                return FDiscountRate;
            }

            public String getFRowType() {
                return FRowType;
            }

            public class FStockStatusIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FEntryPruCostEntity {
                /**
                 * FDetailID : 0
                 */
                private int FDetailID;

                public void setFDetailID(int FDetailID) {
                    this.FDetailID = FDetailID;
                }

                public int getFDetailID() {
                    return FDetailID;
                }
            }

            public static class F_PBXQ_ProjectEntity {
                /**
                 * FNUMBER :
                 */
                private String FNUMBER;

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }

                public String getFNUMBER() {
                    return FNUMBER;
                }
            }

            public class FLotEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FParentMatIdEntity {
                /**
                 * FNUMBER :
                 */
                private String FNUMBER;

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }

                public String getFNUMBER() {
                    return FNUMBER;
                }
            }

            public class FStockLocIdEntity {
            }

            public class FOWNERIDEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FSerialSubEntityEntity {
                /**
                 * FSerialNo :
                 * FDetailID : 0
                 * FSerialNote :
                 */
                private String FSerialNo;
                private int FDetailID;
                private String FSerialNote;

                public void setFSerialNo(String FSerialNo) {
                    this.FSerialNo = FSerialNo;
                }

                public void setFDetailID(int FDetailID) {
                    this.FDetailID = FDetailID;
                }

                public void setFSerialNote(String FSerialNote) {
                    this.FSerialNote = FSerialNote;
                }

                public String getFSerialNo() {
                    return FSerialNo;
                }

                public int getFDetailID() {
                    return FDetailID;
                }

                public String getFSerialNote() {
                    return FSerialNote;
                }
            }

            public class FTaxDetailSubEntityEntity {
                /**
                 * FTaxRate : 0
                 * FDetailID : 0
                 */
                private int FTaxRate;
                private int FDetailID;

                public void setFTaxRate(int FTaxRate) {
                    this.FTaxRate = FTaxRate;
                }

                public void setFDetailID(int FDetailID) {
                    this.FDetailID = FDetailID;
                }

                public int getFTaxRate() {
                    return FTaxRate;
                }

                public int getFDetailID() {
                    return FDetailID;
                }
            }

            public static class FPriceUnitIDEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public static class FUnitIDEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FAuxPropIdEntity {
                /**
                 * FAUXPROPID__FF100001 : {"FNumber":""}
                 */
                private FAUXPROPID__FF100001Entity FAUXPROPID__FF100001;

                public void setFAUXPROPID__FF100001(FAUXPROPID__FF100001Entity FAUXPROPID__FF100001) {
                    this.FAUXPROPID__FF100001 = FAUXPROPID__FF100001;
                }

                public FAUXPROPID__FF100001Entity getFAUXPROPID__FF100001() {
                    return FAUXPROPID__FF100001;
                }

                public class FAUXPROPID__FF100001Entity {
                    /**
                     * FNumber :
                     */
                    private String FNumber;

                    public void setFNumber(String FNumber) {
                        this.FNumber = FNumber;
                    }

                    public String getFNumber() {
                        return FNumber;
                    }
                }
            }

            public class FExtAuxUnitIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public static class FStockIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FTaxCombinationEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public static class FMaterialIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public static class FSetPriceUnitIDEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public class FBOMIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }

            public static class FRemainInStockUnitIdEntity {
                /**
                 * FNumber :
                 */
                private String FNumber;

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }

                public String getFNumber() {
                    return FNumber;
                }
            }
        }

        public class FSettleIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public static class FBillTypeIDEntity {
            /**
             * FNUMBER :
             */
            private String FNUMBER;

            public void setFNUMBER(String FNUMBER) {
                this.FNUMBER = FNUMBER;
            }

            public String getFNUMBER() {
                return FNUMBER;
            }
        }

        public static class FStockerIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public class FSupplyIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }

        public class FChargeIdEntity {
            /**
             * FNumber :
             */
            private String FNumber;

            public void setFNumber(String FNumber) {
                this.FNumber = FNumber;
            }

            public String getFNumber() {
                return FNumber;
            }
        }
    }
}
