<?php

use Illuminate\Database\Seeder;

class UserTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('users')->insert([
            'email' => 'nhutori2@gmail.com',
            'RoleID' => 820000000,
            'Password' => bcrypt('18121998'),
            'codeverify' => 0,
            'active' => 1
        ]);
    }
}
