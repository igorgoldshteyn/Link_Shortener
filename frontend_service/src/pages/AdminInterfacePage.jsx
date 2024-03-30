import React from 'react';

import { useState } from 'react';

function AdminInterfacePage() {

    const [users, setUsers] = useState([]);

    function getAllClients() {
        fetch('http://localhost:8080/getAllClients')
            .then((response) => response.json())
            .then((json) => {
                setUsers(json);
            });
    };

    return (
        <div>
            <br />
            <button onClick={getAllClients}>Get all users</button>
            <div>Users:</div>
            <div>
                <p>
                    {/* todo: add key */}
                    {users.map((user) => (
                        <div>
                            {user.id} {user.firstName} {user.lastName}
                        </div>
                    )
                    )}
                </p>
            </div>
        </div>
    );
}

export default AdminInterfacePage;