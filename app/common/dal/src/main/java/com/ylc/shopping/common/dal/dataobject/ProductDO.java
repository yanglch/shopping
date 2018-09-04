package com.ylc.shopping.common.dal.dataobject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author ylc
*/
public class ProductDO implements Serializable {

    private static final long serialVersionUID = 1534010955044L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 
    * isNullAble:0
    */
    private String name;

    /**
    * 
    * isNullAble:0
    */
    private java.math.BigDecimal price;

    /**
    * 
    * isNullAble:0
    */
    private Integer count;

    /**
    * 
    * isNullAble:0
    */
    private String status;

    /**
    * 
    * isNullAble:0
    */
    private java.time.LocalDateTime gmtCreate;

    /**
    * 
    * isNullAble:0
    */
    private java.time.LocalDateTime gmtUpdate;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setPrice(java.math.BigDecimal price){this.price = price;}

    public java.math.BigDecimal getPrice(){return this.price;}

    public void setCount(Integer count){this.count = count;}

    public Integer getCount(){return this.count;}

    public void setStatus(String status){this.status = status;}

    public String getStatus(){return this.status;}

    public void setGmtCreate(java.time.LocalDateTime gmtCreate){this.gmtCreate = gmtCreate;}

    public java.time.LocalDateTime getGmtCreate(){return this.gmtCreate;}

    public void setGmtUpdate(java.time.LocalDateTime gmtUpdate){this.gmtUpdate = gmtUpdate;}

    public java.time.LocalDateTime getGmtUpdate(){return this.gmtUpdate;}
    @Override
    public String toString() {
        return "ProductDO{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                "count='" + count + '\'' +
                "status='" + status + '\'' +
                "gmtCreate='" + gmtCreate + '\'' +
                "gmtUpdate='" + gmtUpdate + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private ProductDO set;

        private ConditionBuilder where;

        public UpdateBuilder set(ProductDO set){
            this.set = set;
            return this;
        }

        public ProductDO getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends ProductDO {
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<java.math.BigDecimal> priceList;

        public List<java.math.BigDecimal> getPriceList(){return this.priceList;}

        private java.math.BigDecimal priceSt;

        private java.math.BigDecimal priceEd;

        public java.math.BigDecimal getPriceSt(){return this.priceSt;}

        public java.math.BigDecimal getPriceEd(){return this.priceEd;}

        private List<Integer> countList;

        public List<Integer> getCountList(){return this.countList;}

        private Integer countSt;

        private Integer countEd;

        public Integer getCountSt(){return this.countSt;}

        public Integer getCountEd(){return this.countEd;}

        private List<String> statusList;

        public List<String> getStatusList(){return this.statusList;}


        private List<String> fuzzyStatus;

        public List<String> getFuzzyStatus(){return this.fuzzyStatus;}

        private List<String> rightFuzzyStatus;

        public List<String> getRightFuzzyStatus(){return this.rightFuzzyStatus;}
        private List<java.time.LocalDateTime> gmtCreateList;

        public List<java.time.LocalDateTime> getGmtCreateList(){return this.gmtCreateList;}

        private java.time.LocalDateTime gmtCreateSt;

        private java.time.LocalDateTime gmtCreateEd;

        public java.time.LocalDateTime getGmtCreateSt(){return this.gmtCreateSt;}

        public java.time.LocalDateTime getGmtCreateEd(){return this.gmtCreateEd;}

        private List<java.time.LocalDateTime> gmtUpdateList;

        public List<java.time.LocalDateTime> getGmtUpdateList(){return this.gmtUpdateList;}

        private java.time.LocalDateTime gmtUpdateSt;

        private java.time.LocalDateTime gmtUpdateEd;

        public java.time.LocalDateTime getGmtUpdateSt(){return this.gmtUpdateSt;}

        public java.time.LocalDateTime getGmtUpdateEd(){return this.gmtUpdateEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Long id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
            return this;
        }

        public QueryBuilder priceBetWeen(java.math.BigDecimal priceSt,java.math.BigDecimal priceEd){
            this.priceSt = priceSt;
            this.priceEd = priceEd;
            return this;
        }

        public QueryBuilder priceGreaterEqThan(java.math.BigDecimal priceSt){
            this.priceSt = priceSt;
            return this;
        }
        public QueryBuilder priceLessEqThan(java.math.BigDecimal priceEd){
            this.priceEd = priceEd;
            return this;
        }


        public QueryBuilder price(java.math.BigDecimal price){
            setPrice(price);
            return this;
        }

        public QueryBuilder priceList(java.math.BigDecimal ... price){
            this.priceList = solveNullList(price);
            return this;
        }

        public QueryBuilder priceList(List<java.math.BigDecimal> price){
            this.priceList = price;
            return this;
        }

        public QueryBuilder fetchPrice(){
            setFetchFields("fetchFields","price");
            return this;
        }

        public QueryBuilder excludePrice(){
            setFetchFields("excludeFields","price");
            return this;
        }

        public QueryBuilder countBetWeen(Integer countSt,Integer countEd){
            this.countSt = countSt;
            this.countEd = countEd;
            return this;
        }

        public QueryBuilder countGreaterEqThan(Integer countSt){
            this.countSt = countSt;
            return this;
        }
        public QueryBuilder countLessEqThan(Integer countEd){
            this.countEd = countEd;
            return this;
        }


        public QueryBuilder count(Integer count){
            setCount(count);
            return this;
        }

        public QueryBuilder countList(Integer ... count){
            this.countList = solveNullList(count);
            return this;
        }

        public QueryBuilder countList(List<Integer> count){
            this.countList = count;
            return this;
        }

        public QueryBuilder fetchCount(){
            setFetchFields("fetchFields","count");
            return this;
        }

        public QueryBuilder excludeCount(){
            setFetchFields("excludeFields","count");
            return this;
        }

        public QueryBuilder fuzzyStatus (List<String> fuzzyStatus){
            this.fuzzyStatus = fuzzyStatus;
            return this;
        }

        public QueryBuilder fuzzyStatus (String ... fuzzyStatus){
            this.fuzzyStatus = solveNullList(fuzzyStatus);
            return this;
        }

        public QueryBuilder rightFuzzyStatus (List<String> rightFuzzyStatus){
            this.rightFuzzyStatus = rightFuzzyStatus;
            return this;
        }

        public QueryBuilder rightFuzzyStatus (String ... rightFuzzyStatus){
            this.rightFuzzyStatus = solveNullList(rightFuzzyStatus);
            return this;
        }

        public QueryBuilder status(String status){
            setStatus(status);
            return this;
        }

        public QueryBuilder statusList(String ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public QueryBuilder statusList(List<String> status){
            this.statusList = status;
            return this;
        }

        public QueryBuilder fetchStatus(){
            setFetchFields("fetchFields","status");
            return this;
        }

        public QueryBuilder excludeStatus(){
            setFetchFields("excludeFields","status");
            return this;
        }

        public QueryBuilder gmtCreateBetWeen(java.time.LocalDateTime gmtCreateSt,java.time.LocalDateTime gmtCreateEd){
            this.gmtCreateSt = gmtCreateSt;
            this.gmtCreateEd = gmtCreateEd;
            return this;
        }

        public QueryBuilder gmtCreateGreaterEqThan(java.time.LocalDateTime gmtCreateSt){
            this.gmtCreateSt = gmtCreateSt;
            return this;
        }
        public QueryBuilder gmtCreateLessEqThan(java.time.LocalDateTime gmtCreateEd){
            this.gmtCreateEd = gmtCreateEd;
            return this;
        }


        public QueryBuilder gmtCreate(java.time.LocalDateTime gmtCreate){
            setGmtCreate(gmtCreate);
            return this;
        }

        public QueryBuilder gmtCreateList(java.time.LocalDateTime ... gmtCreate){
            this.gmtCreateList = solveNullList(gmtCreate);
            return this;
        }

        public QueryBuilder gmtCreateList(List<java.time.LocalDateTime> gmtCreate){
            this.gmtCreateList = gmtCreate;
            return this;
        }

        public QueryBuilder fetchGmtCreate(){
            setFetchFields("fetchFields","gmtCreate");
            return this;
        }

        public QueryBuilder excludeGmtCreate(){
            setFetchFields("excludeFields","gmtCreate");
            return this;
        }

        public QueryBuilder gmtUpdateBetWeen(java.time.LocalDateTime gmtUpdateSt,java.time.LocalDateTime gmtUpdateEd){
            this.gmtUpdateSt = gmtUpdateSt;
            this.gmtUpdateEd = gmtUpdateEd;
            return this;
        }

        public QueryBuilder gmtUpdateGreaterEqThan(java.time.LocalDateTime gmtUpdateSt){
            this.gmtUpdateSt = gmtUpdateSt;
            return this;
        }
        public QueryBuilder gmtUpdateLessEqThan(java.time.LocalDateTime gmtUpdateEd){
            this.gmtUpdateEd = gmtUpdateEd;
            return this;
        }


        public QueryBuilder gmtUpdate(java.time.LocalDateTime gmtUpdate){
            setGmtUpdate(gmtUpdate);
            return this;
        }

        public QueryBuilder gmtUpdateList(java.time.LocalDateTime ... gmtUpdate){
            this.gmtUpdateList = solveNullList(gmtUpdate);
            return this;
        }

        public QueryBuilder gmtUpdateList(List<java.time.LocalDateTime> gmtUpdate){
            this.gmtUpdateList = gmtUpdate;
            return this;
        }

        public QueryBuilder fetchGmtUpdate(){
            setFetchFields("fetchFields","gmtUpdate");
            return this;
        }

        public QueryBuilder excludeGmtUpdate(){
            setFetchFields("excludeFields","gmtUpdate");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public ProductDO build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<java.math.BigDecimal> priceList;

        public List<java.math.BigDecimal> getPriceList(){return this.priceList;}

        private java.math.BigDecimal priceSt;

        private java.math.BigDecimal priceEd;

        public java.math.BigDecimal getPriceSt(){return this.priceSt;}

        public java.math.BigDecimal getPriceEd(){return this.priceEd;}

        private List<Integer> countList;

        public List<Integer> getCountList(){return this.countList;}

        private Integer countSt;

        private Integer countEd;

        public Integer getCountSt(){return this.countSt;}

        public Integer getCountEd(){return this.countEd;}

        private List<String> statusList;

        public List<String> getStatusList(){return this.statusList;}


        private List<String> fuzzyStatus;

        public List<String> getFuzzyStatus(){return this.fuzzyStatus;}

        private List<String> rightFuzzyStatus;

        public List<String> getRightFuzzyStatus(){return this.rightFuzzyStatus;}
        private List<java.time.LocalDateTime> gmtCreateList;

        public List<java.time.LocalDateTime> getGmtCreateList(){return this.gmtCreateList;}

        private java.time.LocalDateTime gmtCreateSt;

        private java.time.LocalDateTime gmtCreateEd;

        public java.time.LocalDateTime getGmtCreateSt(){return this.gmtCreateSt;}

        public java.time.LocalDateTime getGmtCreateEd(){return this.gmtCreateEd;}

        private List<java.time.LocalDateTime> gmtUpdateList;

        public List<java.time.LocalDateTime> getGmtUpdateList(){return this.gmtUpdateList;}

        private java.time.LocalDateTime gmtUpdateSt;

        private java.time.LocalDateTime gmtUpdateEd;

        public java.time.LocalDateTime getGmtUpdateSt(){return this.gmtUpdateSt;}

        public java.time.LocalDateTime getGmtUpdateEd(){return this.gmtUpdateEd;}


        public ConditionBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public ConditionBuilder priceBetWeen(java.math.BigDecimal priceSt,java.math.BigDecimal priceEd){
            this.priceSt = priceSt;
            this.priceEd = priceEd;
            return this;
        }

        public ConditionBuilder priceGreaterEqThan(java.math.BigDecimal priceSt){
            this.priceSt = priceSt;
            return this;
        }
        public ConditionBuilder priceLessEqThan(java.math.BigDecimal priceEd){
            this.priceEd = priceEd;
            return this;
        }


        public ConditionBuilder priceList(java.math.BigDecimal ... price){
            this.priceList = solveNullList(price);
            return this;
        }

        public ConditionBuilder priceList(List<java.math.BigDecimal> price){
            this.priceList = price;
            return this;
        }

        public ConditionBuilder countBetWeen(Integer countSt,Integer countEd){
            this.countSt = countSt;
            this.countEd = countEd;
            return this;
        }

        public ConditionBuilder countGreaterEqThan(Integer countSt){
            this.countSt = countSt;
            return this;
        }
        public ConditionBuilder countLessEqThan(Integer countEd){
            this.countEd = countEd;
            return this;
        }


        public ConditionBuilder countList(Integer ... count){
            this.countList = solveNullList(count);
            return this;
        }

        public ConditionBuilder countList(List<Integer> count){
            this.countList = count;
            return this;
        }

        public ConditionBuilder fuzzyStatus (List<String> fuzzyStatus){
            this.fuzzyStatus = fuzzyStatus;
            return this;
        }

        public ConditionBuilder fuzzyStatus (String ... fuzzyStatus){
            this.fuzzyStatus = solveNullList(fuzzyStatus);
            return this;
        }

        public ConditionBuilder rightFuzzyStatus (List<String> rightFuzzyStatus){
            this.rightFuzzyStatus = rightFuzzyStatus;
            return this;
        }

        public ConditionBuilder rightFuzzyStatus (String ... rightFuzzyStatus){
            this.rightFuzzyStatus = solveNullList(rightFuzzyStatus);
            return this;
        }

        public ConditionBuilder statusList(String ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public ConditionBuilder statusList(List<String> status){
            this.statusList = status;
            return this;
        }

        public ConditionBuilder gmtCreateBetWeen(java.time.LocalDateTime gmtCreateSt,java.time.LocalDateTime gmtCreateEd){
            this.gmtCreateSt = gmtCreateSt;
            this.gmtCreateEd = gmtCreateEd;
            return this;
        }

        public ConditionBuilder gmtCreateGreaterEqThan(java.time.LocalDateTime gmtCreateSt){
            this.gmtCreateSt = gmtCreateSt;
            return this;
        }
        public ConditionBuilder gmtCreateLessEqThan(java.time.LocalDateTime gmtCreateEd){
            this.gmtCreateEd = gmtCreateEd;
            return this;
        }


        public ConditionBuilder gmtCreateList(java.time.LocalDateTime ... gmtCreate){
            this.gmtCreateList = solveNullList(gmtCreate);
            return this;
        }

        public ConditionBuilder gmtCreateList(List<java.time.LocalDateTime> gmtCreate){
            this.gmtCreateList = gmtCreate;
            return this;
        }

        public ConditionBuilder gmtUpdateBetWeen(java.time.LocalDateTime gmtUpdateSt,java.time.LocalDateTime gmtUpdateEd){
            this.gmtUpdateSt = gmtUpdateSt;
            this.gmtUpdateEd = gmtUpdateEd;
            return this;
        }

        public ConditionBuilder gmtUpdateGreaterEqThan(java.time.LocalDateTime gmtUpdateSt){
            this.gmtUpdateSt = gmtUpdateSt;
            return this;
        }
        public ConditionBuilder gmtUpdateLessEqThan(java.time.LocalDateTime gmtUpdateEd){
            this.gmtUpdateEd = gmtUpdateEd;
            return this;
        }


        public ConditionBuilder gmtUpdateList(java.time.LocalDateTime ... gmtUpdate){
            this.gmtUpdateList = solveNullList(gmtUpdate);
            return this;
        }

        public ConditionBuilder gmtUpdateList(List<java.time.LocalDateTime> gmtUpdate){
            this.gmtUpdateList = gmtUpdate;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private ProductDO obj;

        public Builder(){
            this.obj = new ProductDO();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Builder price(java.math.BigDecimal price){
            this.obj.setPrice(price);
            return this;
        }
        public Builder count(Integer count){
            this.obj.setCount(count);
            return this;
        }
        public Builder status(String status){
            this.obj.setStatus(status);
            return this;
        }
        public Builder gmtCreate(java.time.LocalDateTime gmtCreate){
            this.obj.setGmtCreate(gmtCreate);
            return this;
        }
        public Builder gmtUpdate(java.time.LocalDateTime gmtUpdate){
            this.obj.setGmtUpdate(gmtUpdate);
            return this;
        }
        public ProductDO build(){return obj;}
    }

}
