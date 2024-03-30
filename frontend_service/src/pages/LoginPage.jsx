import React from 'react';

function LoginPage() {

    async function sendLoginPassword() {

        console.log("sendLoginPassword")
    }
    return (
        <div>

            <form action="Post">
                <input type="email" name="Email" id="email"/>
                <input type="password" name="Password" id="password"/>

                <input type="submit" onClick={sendLoginPassword()} value="Sign in"/>
                <input type="button" value="Sign up"/>
            </form>

        </div>
    );
}

export default LoginPage;