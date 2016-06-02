/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teradata.tpcds;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.teradata.tpcds.CatalogPageColumn.CP_CATALOG_NUMBER;
import static com.teradata.tpcds.CatalogPageColumn.CP_CATALOG_PAGE_ID;
import static com.teradata.tpcds.CatalogPageColumn.CP_CATALOG_PAGE_NUMBER;
import static com.teradata.tpcds.CatalogPageColumn.CP_CATALOG_PAGE_SK;
import static com.teradata.tpcds.CatalogPageColumn.CP_DEPARTMENT;
import static com.teradata.tpcds.CatalogPageColumn.CP_DESCRIPTION;
import static com.teradata.tpcds.CatalogPageColumn.CP_END_DATE_ID;
import static com.teradata.tpcds.CatalogPageColumn.CP_START_DATE_ID;
import static com.teradata.tpcds.CatalogPageColumn.CP_TYPE;

public class CatalogPageRow
        extends TableRowWithNulls
{
    private final long cpCatalogPageSk;
    private final String cpCatalogPageId;
    private final long cpStartDateId;
    private final long cpEndDateId;
    private final String cpDepartment;
    private final int cpCatalogNumber;
    private final int cpCatalogPageNumber;
    private final String cpDescription;
    private final String cpType;

    public CatalogPageRow(long cpCatalogPageSk,
                          String cpCatalogPageId,
                          long cpStartDateId,
                          long cpEndDateId,
                          String cpDepartment,
                          int cpCatalogNumber,
                          int cpCatalogPageNumber,
                          String cpDescription,
                          String cpType,
                          long nullBitMap)
    {
        super(nullBitMap);
        this.cpCatalogPageSk = cpCatalogPageSk;
        this.cpCatalogPageId = cpCatalogPageId;
        this.cpStartDateId = cpStartDateId;
        this.cpEndDateId = cpEndDateId;
        this.cpDepartment = cpDepartment;
        this.cpCatalogNumber = cpCatalogNumber;
        this.cpCatalogPageNumber = cpCatalogPageNumber;
        this.cpDescription = cpDescription;
        this.cpType = cpType;
    }

    @Override
    public List<String> getValues()
    {
        Column firstColumn = CP_CATALOG_PAGE_SK;
        return newArrayList(getStringOrNullForKey(cpCatalogPageSk, firstColumn, CP_CATALOG_PAGE_SK),
                            getStringOrNull(cpCatalogPageId, firstColumn, CP_CATALOG_PAGE_ID),
                            getStringOrNullForKey(cpStartDateId, firstColumn, CP_START_DATE_ID),
                            getStringOrNullForKey(cpEndDateId, firstColumn, CP_END_DATE_ID),
                            getStringOrNull(cpDepartment, firstColumn, CP_DEPARTMENT),
                            getStringOrNull(cpCatalogNumber, firstColumn, CP_CATALOG_NUMBER),
                            getStringOrNull(cpCatalogPageNumber, firstColumn, CP_CATALOG_PAGE_NUMBER),
                            getStringOrNull(cpDescription, firstColumn, CP_DESCRIPTION),
                            getStringOrNull(cpType, firstColumn, CP_TYPE));
    }
}