package org.acil.aeipadocker;

import java.util.List;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Hello World 223344!" );
	DockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");

	try {
            System.out.println( "Pinging" ) ;
            String pingResult = docker.ping() ;
            System.out.println( "Ping result " + pingResult ) ;
        } catch (DockerException e) {
            System.out.println( "Docker exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
        } catch (InterruptedException e) {
            System.out.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
        }
        try {
            System.out.println( "Listing Containers" ) ;
            final List<Container> containers = docker.listContainers() ;
            System.out.println( "" + containers.size() + " containers ") ;
            for( Container c : containers ) {
                System.out.println( "ID : " + c.id() ) ;
                System.out.println( "Image : " + c.image() ) ;
            }
        } catch (DockerException e) {
            System.out.println( "Docker exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
        }
        System.out.println( "Bye" ) ;
    }
}
