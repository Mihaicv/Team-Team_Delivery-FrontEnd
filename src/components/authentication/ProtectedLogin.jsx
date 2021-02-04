import React from 'react';
import { Redirect, Route } from 'react-router-dom';

const ProtectedLogin = ({ auth, component: Component, ...rest }) => {
  console.log(auth);
  return (
    <Route
      {...rest}
      render={() =>
        !auth ? <Component /> : <Redirect exact to="/categories" />
      }
    />
  );
};

export default ProtectedLogin;
