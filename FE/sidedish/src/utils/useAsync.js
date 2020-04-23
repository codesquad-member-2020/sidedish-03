import { useEffect, useReducer } from 'react';

const reducer = (state, action) => {
  switch (action.type) {
    case 'LOADING':
      return {
        loading: true,
        data: null,
        error: null,
      };
    case 'SUCCESS':
      return {
        loading: false,
        data: action.data,
        error: null,
      };
    case 'ERROR':
      return {
        loading: false,
        data: null,
        error: action.error,
      };
    default:
      return state;
  }
};

const useAsync = (callback, dpes = []) => {
  const [state, dispath] = useReducer(reducer, {
    loading: false,
    data: null,
    error: null,
  });
  const fetchData = async () => {
    dispath({ type: 'LOADING' });
    try {
      const data = await callback();
      dispath({ type: 'SUCCESS', data });
    } catch (e) {
      dispath({ type: 'ERROR', error: e });
    }
  };
  useEffect(() => {
    fetchData();
    // eslint-disable-next-line
  }, dpes);
  return state;
};

export default useAsync