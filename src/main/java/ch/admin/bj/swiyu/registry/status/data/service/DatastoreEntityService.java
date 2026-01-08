/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bj.swiyu.registry.status.data.service;

import ch.admin.bj.swiyu.registry.status.data.common.exception.ResourceNotFoundException;
import ch.admin.bj.swiyu.registry.status.data.common.exception.ResourceNotReadyException;
import ch.admin.bj.swiyu.registry.status.data.domain.datastore.DatastoreEntity;
import ch.admin.bj.swiyu.registry.status.data.domain.datastore.DatastoreEntityRepository;
import ch.admin.bj.swiyu.registry.status.data.domain.datastore.DatastoreStatus;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DatastoreEntityService {

    private final DatastoreEntityRepository datastoreEntityRepository;

    @Transactional
    public void checkCanShow(DatastoreEntity entry) throws ResourceNotReadyException {
        this.checkCanEdit(entry);
        if (
            !(entry.getStatus() != DatastoreStatus.SETUP && entry.getStatus() != DatastoreStatus.DEACTIVATED)
        ) throw new ResourceNotReadyException(entry.getId().toString());
    }

    @Transactional
    public DatastoreEntity getDatastoreEntity(UUID id) {
        return this.datastoreEntityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id.toString())
            );
    }

    private void checkCanEdit(DatastoreEntity entry) throws ResourceNotReadyException {
        if (entry.getStatus() == DatastoreStatus.DISABLED) throw new ResourceNotReadyException(
            entry.getId().toString()
        );
    }
}
