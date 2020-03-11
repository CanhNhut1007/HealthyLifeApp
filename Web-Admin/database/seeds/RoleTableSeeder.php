<?php

use Illuminate\Database\Seeder;

class RoleTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('role')->insert([
            'RoleName' => 'user'
        ]);
        DB::table('role')->insert([
            'RoleName' => 'admin'
        ]);
        DB::table('role')->insert([
            'RoleName' => 'doctor'
        ]);
    }
}
