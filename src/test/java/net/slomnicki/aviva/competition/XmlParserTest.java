package net.slomnicki.aviva.competition;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Clients;
import net.slomnicki.aviva.competition.service.XmlParser;
import net.slomnicki.aviva.competition.service.XmlParserImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class XmlParserTest {

    @Autowired
    private XmlParser parser;

    @Test
    public void parseGoodFile() throws Exception {
        // given
        File inputFile = new File(getClass()
                .getClassLoader()
                .getResource("AkademiaWiedzyClients.xml")
                .getFile());

        // when
        Clients clients = parser.readAndParseXmlFile(inputFile);

        // then
        assertEquals(4, clients.getClientList().size());
    }

    @Test(expected = XmlParseException.class)
    public void parseBadFile() throws Exception {
        // given
        File inputFile = new File(getClass()
                .getClassLoader()
                .getResource("AkademiaWiedzyClients-bad.xml")
                .getFile());

        // when
        Clients clients = parser.readAndParseXmlFile(inputFile);

        // then
        // noop
    }

    @Test(expected = XmlParseException.class)
    public void parseNonExistingFile() throws Exception {
        // given
        File inputFile = new File("try.to.find.me");

        // when
        Clients clients = parser.readAndParseXmlFile(inputFile);

        // then
        // noop
    }
}