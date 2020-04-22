package ru.mimobaka.mimoplat_v3.dataSource.network.mappers

import ru.mimobaka.mimoplat_v3.dataSource.local.dto.PointDto
import ru.mimobaka.mimoplat_v3.dataSource.network.model.PointNetwork
import ru.mimobaka.mimoplat_v3.model.Point

internal object  NetworkPointMapper {
    fun toNewtwork(point: Point): PointNetwork {
        return point.run {
            PointNetwork(
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

    fun fromNetwork(pointNetwork: PointNetwork): Point {
        return pointNetwork.run {
            Point(
                id,
                name?:"",
                url?:"",
                address?:"",
                lat?:0.0,
                lon?:0.0,
                regionId?:0,
                regionName?:""
            )
        }
    }
}