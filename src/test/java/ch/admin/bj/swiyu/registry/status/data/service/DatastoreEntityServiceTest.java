package ch.admin.bj.swiyu.registry.status.data.service;

import static org.assertj.core.api.Assertions.*;

import ch.admin.bj.swiyu.registry.status.data.common.exception.ResourceNotReadyException;
import ch.admin.bj.swiyu.registry.status.data.domain.datastore.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatastoreEntityServiceTest {

    @InjectMocks
    private DatastoreEntityService service;

    /**
     * Ensures that an entry in state {@code ACTIVE} is accepted.
     */
    @Test
    void checkCanShow_allowsActiveEntry() {
        var entry = new DatastoreEntity(UUID.randomUUID(), DatastoreStatus.ACTIVE);
        assertThatCode(() -> this.service.checkCanShow(entry)).doesNotThrowAnyException();
    }

    /**
     * Ensures that every non‑ACTIVE status is rejected with
     * {@link ResourceNotReadyException}.
     */
    @ParameterizedTest(name = "status={0} should raise ResourceNotReadyException")
    @EnumSource(value = DatastoreStatus.class, names = { "DISABLED", "SETUP", "DEACTIVATED" })
    void checkCanShow_rejectsNonActiveStatuses(DatastoreStatus status) {
        var entry = new DatastoreEntity(UUID.randomUUID(), status);
        assertThatThrownBy(() -> this.service.checkCanShow(entry))
            .as("status=" + status)
            .isInstanceOf(ResourceNotReadyException.class);
    }
}
