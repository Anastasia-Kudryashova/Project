package com.example.project.data.netWork

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupadaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://atogdsqyxphkqgahiycw.supabase.co",
        supabaseKey = "sb_publishable_dqiIkV8el8_cRPM3ZLHFjg_MDKnNHxU"
    ){
        install(Auth)
        install(Postgrest)
    }
}