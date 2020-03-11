<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    @if(session()->has('success'))
        <div class="text-success" role="alert">
            <p>{{ session('success') }}</p>
        </div>
    @elseif(session()->has('error'))
        <div class='text-danger' role="alert">
            <p>{{ session('error') }}</p>
        </div>
    @endif
    <form method="POST" action="{{ route('admin.login') }}">
        @csrf
        <input type="text" name="email" placeholder="email">
        <input type="password" name="password" placeholder="password">
        <button type="submit">Login</button>
    </form>
</body>
</html>