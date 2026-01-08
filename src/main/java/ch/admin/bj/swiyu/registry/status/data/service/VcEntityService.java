/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bj.swiyu.registry.status.data.service;

import ch.admin.bj.swiyu.registry.status.data.common.exception.ResourceNotFoundException;
import ch.admin.bj.swiyu.registry.status.data.domain.VcEntityRepository;
import ch.admin.bj.swiyu.registry.status.data.domain.VcType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class VcEntityService {

    private final VcEntityRepository vcEntityRepository;
    private final DatastoreEntityService datastoreEntityService;

    @Transactional
    public String getTokenStatusListJWT(UUID id) {
        this.datastoreEntityService.checkCanShow(this.datastoreEntityService.getDatastoreEntity(id));
        var optionVc = this.vcEntityRepository.findByBase_IdAndVcType(id, VcType.TokenStatusListJWT);

        if (optionVc.isEmpty()) throw new ResourceNotFoundException(id.toString());

        return optionVc.get().getRawVc();
    }
}
