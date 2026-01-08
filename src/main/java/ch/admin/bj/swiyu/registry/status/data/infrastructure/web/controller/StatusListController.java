/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bj.swiyu.registry.status.data.infrastructure.web.controller;

import ch.admin.bj.swiyu.registry.status.data.service.VcEntityService;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/statuslist")
@AllArgsConstructor
@Tag(name = "Status List", description = "Access Status List entries from the datastore.")
public class StatusListController {

    private final VcEntityService datastoreFileEntityService;

    @Timed
    @GetMapping(value = "/{datastoreEntryId}.jwt", produces = { "application/statuslist+jwt" })
    @Operation(
        summary = "IF-005.001 - Get a tokenstatuslist entry from the datastore.",
        description = "Get a tokenstatuslist entry from the datastore."
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "Returns the tokenstatuslist within a signed JWT",
                useReturnTypeSchema = true
            ),
        }
    )
    public String getTokenStatusList(@PathVariable(name = "datastoreEntryId") UUID datastoreEntryId) {
        return this.datastoreFileEntityService.getTokenStatusListJWT(datastoreEntryId);
    }
}
