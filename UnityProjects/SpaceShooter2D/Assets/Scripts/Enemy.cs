using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    private float _speed = 4.0f;

    void Start()
    {
        transform.position = new Vector3(Random.Range(-8.5f, 8.5f), 7, 0);
        
    }

    void Update()
    {
        transform.Translate(Vector3.down * _speed * Time.deltaTime);

        if (transform.position.y < -5.4f)
        {
            float randX = Random.Range(-8.5f, 8.5f);
            transform.position = new Vector3(randX, 7, 0);

        }
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.tag == "Player")
        {
            other.transform.GetComponent<Player>().Damage();
            Destroy(this.gameObject);

        }
        
        if (other.tag == "Laser")
        {
            Destroy(other.gameObject);
            Destroy(this.gameObject);
            
        }
    }
}
