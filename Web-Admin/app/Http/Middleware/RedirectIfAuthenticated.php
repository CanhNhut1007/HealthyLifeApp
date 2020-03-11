<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;

class RedirectIfAuthenticated
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @param  string|null  $guard
     * @return mixed
     */
    public function handle($request, Closure $next, $guard = null)
    {
        if ($guard == "admin" && Auth::guard($guard)->check()) {
            return redirect('admin/dashboard');
        }
        if ($guard == "doctor" && Auth::guard($guard)->check()) {
            return redirect('doctor/home');
        }
        if (Auth::guard($guard)->check()) {
            return redirect('member/home');
        }
        return $next($request);
    }
}
