/*
 * Copyright 2017 cnl.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package esa.mep.downloader.util;

import _int.esa.proba_v_mep.schemas.downloadmanager.DownloadRequest;
import _int.esa.proba_v_mep.schemas.downloadmanager.DownloadStatus;
import _int.esa.proba_v_mep.schemas.downloadmanager.ObjectFactory;
import _int.esa.proba_v_mep.schemas.downloadmanager.ProductStatusType;
import _int.esa.proba_v_mep.schemas.downloadmanager.ProductType;
import _int.esa.proba_v_mep.schemas.downloadmanager.ProgressType;
import _int.esa.proba_v_mep.schemas.downloadmanager.StatusType;
import int_.esa.eo.ngeo.downloadmanager.plugin.EDownloadStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods for handling conversion to / from Downloader Bindings
 *
 * @author cnl
 */
public class DownloaderBindings {

    private static ObjectFactory of = new ObjectFactory();

    /**
     * Convert progress values into an download XML ProgressType
     *
     * @param progressPercentage
     * @param downloadedSize
     * @param status
     * @param message
     * @return progress type
     */
    public static ProgressType getProgressType(Integer progressPercentage, Long downloadedSize, EDownloadStatus status, String message) {
        return of.createProgressType().withProgressPercentage(progressPercentage)
                .withDownloadedSize(downloadedSize)
                .withStatus(getStatus(status))
                .withMessage(message);
    }

    
    
    /**
     * Convert a plugin status to the downloader XML status type
     *
     * @param status plugin status
     * @return downloader status Comment: downloader status may not contain
     * paused status ! (@TODO update schemas?)
     */
    public static StatusType getStatus(EDownloadStatus status) {
        return StatusType.valueOf(status.toString());
    }

    public static DownloadStatus createDownloadStatus(DownloadRequest request, String identifier) {
        DownloadStatus downloadStatus = of.createDownloadStatus().withIdentifier(identifier)
                .withName(request.getName());
        List<ProductStatusType> products = new ArrayList<>();
        for (ProductType p : request.getProducts()) {
            ProductStatusType ps = of.createProductStatusType()
                    .withProductURL(p.getURL())
                    .withTotalFileSize(0)
                    .withDownloadDirectory(null)
                    .withProductName(null)
                    .withDownloadDirectory(p.getDownloadDirectory())
                    .withProductProgress(getProgressType(0, new Long(0), EDownloadStatus.NOT_STARTED, "Job download created"));
            products.add(ps);
        }
        downloadStatus.setProductStatuses(products);
        return downloadStatus;
    }

}
