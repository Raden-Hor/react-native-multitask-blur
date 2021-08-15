import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import MultitaskBlur from 'react-native-multitask-blur';

export default function App() {
  return (
    <View style={styles.container}>
      <Button title="Blur" onPress={() => MultitaskBlur.blur()} />
      <Button title="Blur" onPress={() => MultitaskBlur.unBlur()} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
