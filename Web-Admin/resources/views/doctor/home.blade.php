<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <p>Login success with doctor v2</p>
    <form method="POST" action="{{route('doctor.logout')}}">
    @csrf
        <input type='submit' name='logout' value='logout'>
    </form>
</body>
</html>