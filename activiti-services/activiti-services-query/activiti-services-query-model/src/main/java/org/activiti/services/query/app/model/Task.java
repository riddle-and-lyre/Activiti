/*
 * Copyright 2017 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.services.query.app.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    @Id
    private String id;
    private String assignee;
    private String name;
    private String description;
    private Date createTime;
    private Date dueDate;
    private String priority;
    private String category;
    private String processDefinitionId;
    private String processInstanceId;
    private String status;
    private Date lastModified;

    @OneToMany
    private List<Variable> variables;

    public Task() {
    }

    @JsonCreator
    public Task(@JsonProperty("id") String id,
                @JsonProperty("assignee") String assignee,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("createTime") Date createTime,
                @JsonProperty("dueDate") Date dueDate,
                @JsonProperty("priority") String priority,
                @JsonProperty("category") String category, //TODO: what is this? it doesn't get populated
                @JsonProperty("processDefinitionId") String processDefinitionId,
                @JsonProperty("processInstanceId") String processInstanceId,
                @JsonProperty("status") String status,
                @JsonProperty("lastModified") Date lastModified,
                @JsonProperty("variables") List<Variable> variables) {
        this.id = id;
        this.assignee = assignee;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.processDefinitionId = processDefinitionId;
        this.processInstanceId = processInstanceId;
        this.status = status;
        this.lastModified = lastModified;
        this.variables=variables;
    }

    public String getId() {
        return id;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public String getStatus() {
        return status;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @JsonIgnore
    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }
}