package ru.mimobaka.mimoplat_v3.dataSource.local.mappers

import ru.mimobaka.mimoplat_v3.dataSource.local.dto.PointDto
import ru.mimobaka.mimoplat_v3.model.Point

internal object LocalPointMapper {

    fun toDto(point: Point): PointDto {
        return point.run {
            PointDto(
                id,
                name,
                url,
                address,
                lat,
                lon,
                regionId,
                regionName
            )
        }
    }

    fun fromDto(pointDto: PointDto): Point {
        return pointDto.run {
            Point(
                id,
                name,
                url,
                address,
                lat,
                lon,
                regionId,
                regionName
            )
        }
    }
}