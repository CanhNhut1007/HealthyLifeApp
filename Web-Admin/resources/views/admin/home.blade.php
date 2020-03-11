<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <p>Login success with admin v2</p>
    <form method="POST" action="{{route('admin.logout')}}">
        @csrf
        <input type='submit' name='logout' value='logout'>
    </form>
</body>
</html>