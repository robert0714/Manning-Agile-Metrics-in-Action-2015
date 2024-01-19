package com.nike.mm.entity.internal

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldIndex
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "measurementor", type="jobpluginhistory")
class JobConfigHistory {

    @Id
    @Field(type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    String id

    @Field(type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    String jobid

    @Field(type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    String jobHistoryid

    @Field(type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    String type

    @Field(type = FieldType.Date,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    Date startDate

    @Field(type = FieldType.Date,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    Date endDate

    @Field(type = FieldType.Integer,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    Integer recordsCount

    @Field(type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    JobHistory.Status status

    @Field(type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "standard",
            
            store = true)
    String comments
}
