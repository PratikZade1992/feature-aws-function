package com.awslamda.demo.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.awslamda.demo.model.Feature;
import com.awslamda.demo.model.GateWayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.awslamda.demo.config.DynamoMapper.dynamoDBMapperSupplier;
import static com.awslamda.demo.utils.FeatureUtil.*;


/**
 * The type Feature dao.
 */
public class FeatureDao {

    private static final Logger log = LoggerFactory.getLogger(FeatureDao.class);

    private final DynamoDBMapper dbMapper = dynamoDBMapperSupplier.get();

    /**
     * addFeature :  used to added feature in to DB
     *
     * @param feature the feature
     * @return the string
     */
    public GateWayResponse addFeature(Feature feature) {
        // code for add new feature
        log.debug("Adding feature : [{}]", feature);
        Feature record = getFeature(feature.getCustId(), feature.getFeatureCode());
        if (record == null) {
            try {
                DynamoDBMapper dbMapper = dynamoDBMapperSupplier.get();
                dbMapper.save(feature);
                return getSuccessResponse.apply("Success : Feature inserted ", feature);
            } catch (Exception exception) {
                log.error("Insertion failed  :", exception);
                return getInternalErrorResponse.apply("Failed : Got error while inserting " + exception.getMessage(),feature);
            }
        } else {
            return getBadRequestResponse.apply("Failed : record is already present",feature);
        }
    }

    /**
     * updateFeature :To update feature record
     *
     * @param feature the feature
     * @return the string
     */
    public GateWayResponse updateFeature(Feature feature) {
        // code for add new feature
        log.debug("Adding feature : [{}]", feature);
        Feature record = getFeature(feature.getCustId(), feature.getFeatureCode());// fetch existing records
        if (record != null) {// verify record is present or not
            try {
                record.setFeatureName(feature.getFeatureName());
                record.setEnable(feature.getEnable());
                dbMapper.save(record);// update existing records
                return getSuccessResponse.apply("Success : Feature updated ",feature) ;
            } catch (Exception exception) {
                log.error("Insertion failed  :", exception);
                return getInternalErrorResponse.apply("Failed : Got error while updating " + exception.getMessage(),feature);
            }
        } else {
            return getRecordNotFoundResponse.apply("Failed : record not found",feature);
        }
    }

    /**
     * getFeature : fetch existing feature.
     *
     * @param custID      the cust id
     * @param featureCode the feature code
     * @return the feature
     */
    public Feature getFeature(Integer custID, String featureCode) {

        Map<String, AttributeValue> valueMap = new HashMap<>();

        valueMap.put(":featureCode", new AttributeValue().withS(featureCode));
        valueMap.put(":custId", new AttributeValue().withN(custID.toString()));

        DynamoDBQueryExpression<Feature> objectDynamoDBQueryExpression = new DynamoDBQueryExpression<Feature>()
                .withKeyConditionExpression("Feature_code = :featureCode and custId = :custId")
                .withExpressionAttributeValues(valueMap);

        log.debug("Dynamodb expression key set : [{}]", objectDynamoDBQueryExpression.toString());

        PaginatedQueryList<Feature> features = dynamoDBMapperSupplier.get().query(Feature.class, objectDynamoDBQueryExpression);

        return features != null && features.size() > 0 ? features.get(0) : null;
    }
}
