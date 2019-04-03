package com.demo.serializer;

import com.demo.util.AvroDeserializer;
import example.avro.User;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class AvroDeserializerTest {

    @Test
    public void testDeserialize() {
        User user = User.newBuilder().setName("John Doe").setFavoriteColor("green")
                .setId(null).build();

        byte[] data = DatatypeConverter.parseHexBinary("104A6F686E20446F6502000A677265656E");

        AvroDeserializer<User> avroDeserializer = new AvroDeserializer<>(User.class);

        assertThat(avroDeserializer.deserialize("avro.t", data)).isEqualTo(user);
        avroDeserializer.close();
    }
}
